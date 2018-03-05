import java.util.ArrayList;
import java.util.Scanner;

class HighestInt {
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