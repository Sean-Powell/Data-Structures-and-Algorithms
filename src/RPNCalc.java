import java.util.Stack;

class RPNCalc {
    private String input;//inputs are separated via spaces
    private Stack<Double> stack = new Stack<>();

    void SetInput(String newInput) {
        input = newInput;
    }

    boolean validateInput(){
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
                        System.out.println("Subtraction:");
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

