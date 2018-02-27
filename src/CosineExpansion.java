public class CosineExpansion {
    double expansion(double x, int k){
        double ans = 0;
        for(int i = 0; i < k; i++){
            ans =+ (Math.pow((-1), k) * Math.pow(x, 2*k) / factorial(2*k));
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
