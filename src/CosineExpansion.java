public class CosineExpansion {
    double expansion(double x, int k){
        double ans = 0;
        for(int i = 0; i < k; i++){
            if(i == 0){
                ans = 1;
            }else {
                ans += (Math.pow(-1, i) * Math.pow(x, 2 * i)) / factorial(2 * i);
            }
        }
        return ans;
    }
    private double factorial(int x){
        double ans;
        if(x == 1){
            return 1;
        }
        ans = factorial(x - 1) * x;
        return ans;
    }
}
