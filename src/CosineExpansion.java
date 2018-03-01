public class CosineExpansion {
    double expansion(double x, int k){
        double ans = 0;
        for(int i = 0; i < k; i++){
            ans =+ (Math.pow((-1), k) * Math.pow(x, (2*k + 1)) / factorial(2*k + 1));
        }
        return ans;
    }
    int factorial(int x){
        int ans;
        if(x == 1){
            return 1;
        }
        ans = factorial(x - 1) * x;
        return ans;
    }
}
