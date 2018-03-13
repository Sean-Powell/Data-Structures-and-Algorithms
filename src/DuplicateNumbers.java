import java.util.ArrayList;
import java.util.Scanner;

class DuplicateNumbers {
    private Scanner scan = new Scanner(System.in);

    /*
    This methods goes though a list
     */
    void findDuplicates(ArrayList<Integer> _list){
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        ArrayList<Integer> duplicateNumbers = new ArrayList<>();
        boolean found;
        for (Integer aList : _list) {
            int x = aList;
            found = false;
            if (!uniqueNumbers.isEmpty()) {
                for (int j = 0; j < uniqueNumbers.size(); j++) {
                    if (x == uniqueNumbers.get(j)) {
                        found = true;
                        duplicateNumbers.add(uniqueNumbers.get(j));
                        uniqueNumbers.remove(j);
                    }
                }
            }

            if (!found) {
                uniqueNumbers.add(x);
            }
        }

        System.out.println("Duplicate numbers: " + duplicateNumbers.toString());
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
                return list;
            }
        }
    }
}
