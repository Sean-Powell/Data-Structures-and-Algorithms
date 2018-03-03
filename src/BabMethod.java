class BabMethod {
    double approximate(int number, int ittertions){
        double ans = number / 2;

        for(int i = 0; i < ittertions; i++){
            ans = (ans + (number / ans)) * 0.5;
        }

        return ans;
    }
}
