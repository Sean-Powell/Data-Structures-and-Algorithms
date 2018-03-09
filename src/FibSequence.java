public class FibSequence {
    //after n > 103 the long with have an overflow
    /*
     The method iteratively loops through calculating the fibonacci sequence up to the degree that the user desires.
     */
    long fibonacci(int _n){
        long oldFib = 1; //stores the oldest fib number
        long fibValue = 1; //stores the current value of the fib sequence.
        long x; //temp int for holding the old value of fib
        for(int i = 0; i < (_n - 2); i++){
            x = fibValue;
            fibValue += oldFib;
            oldFib = x;
        }
        return fibValue;
    }
}
