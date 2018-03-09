import java.util.ArrayList;
import java.util.Scanner;

class HighestInt {
    /*
     This method is called so that the user can input the numbers to the list that they want to check. It will loop until
     the user inputs anything other than a number.
     */
    ArrayList<Integer> populateList(){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while(true){
            try{
                System.out.println("Enter a number to add it to the list, enter anything other than a number to quit");
                list.add(scan.nextInt());
            }catch (Exception e){
                return list;
            }
        }
    }
    /*
     This method recursively checks a list for the largest number that is in it. It does this by recursively calling itself
     working its way down the list till it is at the last element. It then returns this number. Then as it goes back through
     its calls it will check the number that, that specific call removed from the list. The method will return the largest
     of these two numbers.
     */
    int largestInt(ArrayList<Integer> _list){
        if(_list.size() == 1){
            return _list.get(0);
        }else{
            int num1 = _list.get(0);
            _list.remove(0);
            int num2 = largestInt(_list);
            if(num1 > num2){
                return num1;
            }else{
                return num2;
            }
        }
    }
}