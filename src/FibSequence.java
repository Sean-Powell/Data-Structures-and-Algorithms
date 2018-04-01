import java.math.BigInteger;

public class FibSequence {
    /*
     The method iteratively loops through calculating the fibonacci sequence up to the degree that the user desires.
     */
    BigInteger fibonacci(int _n){
        BigInteger oldFib = BigInteger.valueOf(1);
        BigInteger fibValue = BigInteger.valueOf(1);
        BigInteger temp;

        for(int i = 0; i < (_n - 2); i++){
            temp = fibValue;
            fibValue = fibValue.add(oldFib);
            oldFib = temp;
        }

        return fibValue;
    }
}
