public class run {
    private static RPNCalc rpnc = new RPNCalc();
    private static PrimeNumbers prime = new PrimeNumbers();
    public static void main(String[] args){
        rpnc.SetInput("15 7 1 1 + - / 3 * 2 1 1 + + -");
        long startTime = System.currentTimeMillis();
        System.out.println(rpnc.validateInput()); //prints true when valid and false otherwise.
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken in milliseconds: " + (endTime - startTime));
        //System.out.println(3 % 6);
        prime.sieve();
    }
}
