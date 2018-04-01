public class Expansion {
    double cosExpansion(double _x, int _y){
        double ans = 0;
        for(int i = 0; i < _y; i++){
            if(i == 0){
                ans = 1;
            }else {
                ans += (Math.pow(-1, i) * Math.pow(_x, 2 * i)) / factIt(2 * i);
            }
        }
        return ans;
    }

    double sinExpansion(double _x, int _y){
        double ans = 0;
        for(int i = 0; i < _y; i++){
            if(i == 0){
                ans = _x;
            }else{
                ans += (Math.pow(-1, i) * Math.pow(_x, (2 * i) + 1) / factIt((2 * i) + 1));
            }
        }
        return ans;
    }

    private long factIt(int x){
        long ans = 1;
        while(x >= 1){
            ans = ans * x;
            x--;
        }
        return ans;
    }
}
