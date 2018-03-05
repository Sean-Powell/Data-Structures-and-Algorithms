import java.util.ArrayList;
import java.util.Scanner;

class DuplicateNumbers {
    private Scanner scan = new Scanner(System.in);
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
