class BabMethod {
    double approximate(int _number, int _iterations){
        double ans = _number / 2;

        for(int i = 0; i < _iterations; i++){
            ans = (ans + (_number / ans)) * 0.5;
        }

        return ans;
    }
}
