import java.util.ArrayList;
import java.util.Scanner;

class PrimeNumbers {
    /*
    //This is an array of numbers that is the difference between the 1,3,7,9 after the number 11. This save both memory
    and processing time as it removes all the numbers that are even or divisible by 5
     */
    private int[] additionAmount = {1, 2, 1};
    private int j;//stores which element in the additionalAmount array is next to be used.

    private int addAmount(){
        /*
        This method when called will return the correct amount from the additionalAmount array,
        it also resets j back to 0 when it reaches 3 this stops an arrayOutOfBoundsException from happening.
         */
        if(j == 3){
            j = 0;
        }
        return additionAmount[j];
    }

    Boolean isPrime(int _x) {
        /*
        This method takes an input integer from the user _x. The square root of the number that was inputted and then
        rounded up. The method then checks if the input is dividable with no remainder by the current number. If the number
        is less than the square root but greater than 11. Then the addAmount method that was outlined above. If the method
        finds a factor it will return false if it reaches the end of the for loop without finding any factors then it will
        return true
         */
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
        /*
        This method first creates a scanner object reading from System.in it then prompts the user on what number they
        want to run the sieve up to. This will loop up until the user enters a number that is greater than 0
        The square root is then calculated and rounded up in the case that it is not an integer. The method then populates
        a list of numbers from 2 all the way up until n. This also uses the addAmount method as outlined above to reduce
        the numbers in the list. The method then loops through from 2 through till the number it retrieves from the list
        is greater than the square root. If it is less then it goes through the list checking if that number is a factor
        of any number in the list. If it is a factor then the the number that it is a factor of it removed. After it has
        gone through all the number less than the square root it then prints the list with 4 numbers on every line.
        This printing is in a try catch block so that if there is not 4 numbers in the list left to be printed it won't crash
        and will only print the amount that is left and will create a new line at the end
         */
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
                /*this stops the program from throwing an error in the cases where the square root of the number is larger than the size of the list
                Since the list starts at 2 if the user was to input the upper limit is 2 then, the list will be 1 size and the square root will be 1
                but since the array starts from 0 there is gonna be two access requests with the latter one causing an out of bounds exception.
                */
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