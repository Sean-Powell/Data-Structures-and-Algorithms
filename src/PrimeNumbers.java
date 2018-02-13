import java.util.ArrayList;

public class PrimeNumbers {
    void sieve(){
        int n = 1000;
        int sqrtN = (int) Math.ceil(Math.sqrt(n));
        boolean end;
        //Populate listOfPrimes up to including n;
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            listOfPrimes.add(i);
        }

        for(int i = 0; i < sqrtN; i++){
            if(listOfPrimes.get(i) <= sqrtN){
                int j = 0;
                int divisor = listOfPrimes.get(i);
                end = true;
                while(end){
                    try {
                        if (listOfPrimes.get(j) % divisor == 0 && listOfPrimes.get(j) != divisor) {
                            listOfPrimes.remove(j);
                        }
                        j++;
                    }catch (Exception e) {
                        end = false;
                    }
                }
            }
        }

        for (Integer aList : listOfPrimes) {
            System.out.println(aList + ",");
        }
    }
}
