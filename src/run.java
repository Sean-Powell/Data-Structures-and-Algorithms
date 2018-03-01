import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class run {
    private static PairMatrix PM = new PairMatrix();
    private static RPNCalc rpnc = new RPNCalc();
    private static PrimeNumbers prime = new PrimeNumbers();
    private static BinaryTree BT = new BinaryTree();
    private static HighestInt high = new HighestInt();
    private static FibSequence fib = new FibSequence();
    private static CosineExpansion CE = new CosineExpansion();
    private static DuplicateNumbers DN = new DuplicateNumbers();

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
                        PM.start();
                        break;
                    case 2:
                        System.out.println("Enter the RPN expression to be checked separate each element by a space.");
                        String expression = readString();
                        rpnc.SetInput(expression);
                        System.out.println("The Equation is " + rpnc.validateInput());
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
                        DN.findDuplicates(DN.popList());
                        break;
                    case 7:
                        System.out.println(high.largestInt(high.populateList()));
                        break;
                    case 8:
                        try {
                            System.out.println("Please enter the value of X in cos(X)");
                            double x = scan.nextDouble();
                            System.out.println("Please enter the degree you want to calculate the expansion to");
                            int k = scan.nextInt();
                            System.out.printf("%f\n", CE.expansion(x, k));
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
