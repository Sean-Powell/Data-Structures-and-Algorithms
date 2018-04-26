import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class DuplicateNumbers {
    private Scanner scan = new Scanner(System.in);

    /*
    Change this method to use a hashing function to see if numbers appear multiple times in the list.
     */

    void findDuplicatesHash(ArrayList<Integer> _list){
        ArrayList<byte[]> hashList = new ArrayList<>();
        ArrayList<Integer> duplicateNumbers = new ArrayList<>();
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            boolean found;
            for (Integer a_list : _list) {
                byte[] hash = messageDigest.digest(a_list.toString().getBytes(StandardCharsets.UTF_8));
                found = false;
                for (byte[] aHashList : hashList) {
                    if (Arrays.equals(hash, aHashList)) {
                        found = true;
                    }
                }
                if (found) {
                    duplicateNumbers.add(a_list);
                } else {
                    hashList.add(hash);
                }
            }
            System.out.println(duplicateNumbers.toString());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

    }

    /*
     This method prompts the user to enter numbers to populate the list of numbers that will be checked for unique numbers
     this will once again loop until the user enters a input that is not a number.
     */
    ArrayList<Integer> popList(){
        ArrayList<Integer> list = new ArrayList<>();
        while (true){
            try{
                System.out.println("Enter a number to add to the list, enter any thing other than a number to stop");
                list.add(scan.nextInt());
            }catch(Exception e){
                scan = null;
                scan = new Scanner(System.in);
                return list;
            }
        }
    }
}
