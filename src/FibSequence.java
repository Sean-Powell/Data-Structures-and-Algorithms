public class FibSequence {
    //after n > 103 the long with have an overflow
    long fibonacci(int n){
        long oldFib = 1;
        long fibValue = 1;
        long x; //temp int for holding the old value of fib
        for(int i = 0; i < (n - 2); i++){
            x = fibValue;
            fibValue += oldFib;
            oldFib = x;
        }
        return fibValue;
    }
}
