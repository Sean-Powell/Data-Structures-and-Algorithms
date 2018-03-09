class BabMethod {
    /*
     This method first halves the number that the user inputted as the first guess for the square root. The runs the
     method for getting closer to the actual value by the number of iterations the user requested be run.
     */
    double approximate(int _number, int _iterations){
        double ans = _number / 2;//first guess

        for(int i = 0; i < _iterations; i++){ //runs for how many iterations the user requested
            ans = (ans + (_number / ans)) * 0.5;
        }

        return ans;//returns the answer
    }
}
