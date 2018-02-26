import java.util.Scanner;

public class NewtonRaphson {
    /*limited to equations in the form ax^n +/- bx^n-1 .... +/- zx^0 | a,b and z being independent coefficients inputted by the users*/
    private Scanner scanner = new Scanner(System.in);

    void findNewtonRaphson(){
        System.out.println("Please input the highest power in the equation");
        int highestPower = scanner.nextInt();
        int multiplier;
        double initialEstimate = 1;
        double tolerance = 10^(-10); //digets of precision required.
        double epsilon = 10^(-14); //do not divide a number lower than that.
        int maxItterations = 20;
        boolean solutionFound = false;
        

        int coefficients[] = new int[highestPower];
        int dereviteCoefficients[] = new int[highestPower];

        System.out.println("Please input the coefficients starting at the highest power");
        for(int i = 0; i < highestPower; i++){
            System.out.println("Please input the " + (i+1) + " coefficients");
            coefficients[i] = scanner.nextInt();

            //works out the derivative of the equation
            multiplier = (highestPower - i - 1);
            if(multiplier > 0) {
                dereviteCoefficients[i] = coefficients[i] * multiplier;
            }else{
                dereviteCoefficients[i] = 0;
            }
        }


    }
}
