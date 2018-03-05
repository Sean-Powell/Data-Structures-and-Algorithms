public class CosineExpansion {
    double expansion(double _x, int _k){
        double ans = 0;
        for(int i = 0; i < _k; i++){
            if(i == 0){
                ans = 1;
            }else {
                ans += (Math.pow(-1, i) * Math.pow(_x, 2 * i)) / factorial(2 * i);
            }
        }
        return ans;
    }
    private double factorial(int _x){
        double ans;
        if(_x == 1){
            return 1;
        }
        ans = factorial(_x - 1) * _x;
        return ans;
    }
}
