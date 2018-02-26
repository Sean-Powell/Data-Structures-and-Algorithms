public class CosineExpansion {
    double expansion(int x, int k){
        double ans = 0;
        for(int i = 0; i < k; i++){
            ans =+ ((Math.pow(-1, k) * Math.pow(x, (2 * k) + 1)) / factorial(2 * k + 1));
        }
        return ans;
    }

    private double factorial(int x){
        double ans = 1;
        for(int i = 2; i < x; i++){
            ans *= i;
        }
        return ans;
    }
}
