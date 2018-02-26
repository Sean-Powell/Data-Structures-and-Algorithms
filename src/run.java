import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class run {
    private static RPNCalc rpnc = new RPNCalc();
    private static PrimeNumbers prime = new PrimeNumbers();
    private static BinaryTree BT = new BinaryTree();
    private static HighestInt high = new HighestInt();
    private static FibSequence fib = new FibSequence();
    private static CosineExpansion CE = new CosineExpansion();

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            System.out.println("Please input a number from 1-9 to select the question you want to run");
            System.out.println("Enter -1 to quit");
            int selected = scan.nextInt();
            if (selected >= 1 && selected <= 9 || selected == -1) {
                switch (selected) {
                    case -1:
                        exit = true;
                        break;
                    case 1:
                        break;
                    case 2:
                        System.out.println("Enter the RPN expression to be checked separate each element by a space.");
                        String expression = readString();
                        rpnc.SetInput(expression);
                        rpnc.validateInput();
                        break;
                    case 3:
                        System.out.println("Enter 1 to check if a number is prime or 2 if you want to run the sieve of Eratosthenes");
                        selected = scan.nextInt();
                        if(selected == 1 || selected == 2){
                            switch (selected) {
                                case 1:
                                    System.out.println("Plese input a number to check");
                                    int inputNum = scan.nextInt();
                                    System.out.println(prime.isPrime(inputNum));

                                    break;
                                case 2:
                                    prime.sieve();
                                    break;
                                default:
                                    System.out.print("Invalid input");
                                    break;

                            }
                        }
                        break;
                    case 4:
                        BT.start();
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        System.out.println(high.largestInt(high.populateList()));
                        break;
                    case 8:
                        try {
                            System.out.println("Please enter the value of X in cos(X)");
                            int x = scan.nextInt();
                            System.out.println("Please enter the degree you want to calculate the expansion to");
                            int k = scan.nextInt();
                            System.out.printf("%.2f\n", CE.expansion(x, k));
                        }catch(Exception e){
                            System.out.println("An error has occurred");
                            e.printStackTrace();
                        }
                        break;
                    case 9:
                        System.out.println("Enter the degree which you want to calculate the fibonacci sequence to ");
                        try{
                            int n = scan.nextInt();
                            System.out.println(fib.fibonacci(n));
                        }catch (Exception e){
                            System.out.println("A error occurred");
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        }
        while(true) {
            try {

                System.out.println("Plese input a number to check");
                System.out.println(prime.isPrime(scan.nextInt()));
                prime.sieve();
                //BT.start();
                rpnc.SetInput("5 6 * 4 / 12 3 * +");
                long startTime = System.currentTimeMillis();
                System.out.println(rpnc.validateInput()); //prints true when valid and false otherwise.
                long endTime = System.currentTimeMillis();
                System.out.println("Time taken in milliseconds: " + (endTime - startTime));
                //System.out.println(3 % 6);
            } catch (Exception e) {
                System.out.println("An error occurred");
            }
        }
    }

    private static String readString(){
        BufferedReader br;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
