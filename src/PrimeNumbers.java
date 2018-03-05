import java.util.ArrayList;
import java.util.Scanner;

class PrimeNumbers {
    private int[] additionAmount = {1, 2, 1};
    private int j;
    private int addAmount(){
        int x = additionAmount[j];
        if(j == 3){
            j = 0;
        }
        return x;
    }
    Boolean isPrime(int _x) {
        j = 0;
        int sqr = (int) Math.ceil(Math.sqrt(_x));
        for (int i = 2; i <= sqr; i++) {
            if (_x % i == 0) {
                return false;
            }
            if (i >= 11) {
                i += addAmount();
            }
        }
        return true;
    }

    void sieve() {
        int n;
        j = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Please input the n you wish to go to");
            n = scan.nextInt();
            if (n > 0) {
                break;
            }
        }
        int sqrtN = (int) Math.ceil(Math.sqrt(n));
        boolean end;
        //Populate listOfPrimes up to including n;
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            listOfPrimes.add(i);
            if (i >= 11) {
                i += addAmount();
            }
        }

        for (int i = 0; i < sqrtN; i++) {
            if (i >= listOfPrimes.size()) {
                i = sqrtN + 1;
            } else {
                if (listOfPrimes.get(i) <= sqrtN) {
                    j = 0;
                    int divisor = listOfPrimes.get(i);
                    end = true;
                    while (end) {
                        try {
                            if (listOfPrimes.get(j) % divisor == 0 && listOfPrimes.get(j) != divisor) {
                                listOfPrimes.remove(j);
                            }
                            j++;
                        } catch (Exception e) {
                            end = false;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < listOfPrimes.size(); i = i + 4) {
            try {
                System.out.print(listOfPrimes.get(i) + ", ");
                System.out.print(listOfPrimes.get(i + 1) + ", ");
                System.out.print(listOfPrimes.get(i + 2) + ", ");
                System.out.println(listOfPrimes.get(i + 3) + ", ");
            } catch (Exception e) {
                System.out.println();
                break;
            }
        }
    }
}