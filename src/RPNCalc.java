import java.util.Stack;

class RPNCalc {
    private String input;//inputs are separated via spaces
    private Stack<Double> stack = new Stack<>();

    void SetInput(String _newInput) {
        /*
        Sets the input that the user inputted to the calculator, also checks if the input has been set to null as the
        method that gets the user input can pass null to this function if an error occurs.
         */
        input = _newInput;
    }

    boolean validateInput(){
        /*
        This method first splits the input into different elements with a regex of " " this list is then processed, if
        the method finds a + - / * then it will remove the top two numbers from the stack preform the respective operation
        on these two number then will add the answer back onto the stack. If the element is not an operation symbol then
        it is added to the stack. This function is surrounded in a try catch block as various errors can occur during
        the processing. The main on being that there was an invalid input entered and when an operation was attempted there
        was not two numbers on the stack to preform an operation on. This method will return false if there is any error
        or by the end of the input there is more than one element on the stack. If there is only one element on the stack
        Then the method will return true as the input was a valid RPN formula.
         */

        String[] splitInput = input.split(" ");
        try {
            for (String aSplitInput : splitInput) {
                switch (aSplitInput) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        System.out.println("Addition:");
                        System.out.println(stack.toString());
                        break;
                    case "-":
                        double secondNum = stack.pop();
                        double firstNum = stack.pop();
                        System.out.println("Subtraction:");
                        stack.push(firstNum - secondNum);
                        System.out.println(stack.toString());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        System.out.println("Multiplication:");
                        System.out.println(stack.toString());
                        break;
                    case "/":
                        secondNum = stack.pop();
                        firstNum = stack.pop();
                        System.out.println("Division:");
                        stack.push(firstNum / secondNum);
                        System.out.println(stack.toString());
                        break;
                    default:
                        double temp = Integer.parseInt(aSplitInput);
                        stack.push(temp);
                        System.out.println(stack.toString());
                        break;
                }
            }
            stack.pop();
            return stack.empty();
        }catch (Exception e){
            return false;
        }
    }
}

