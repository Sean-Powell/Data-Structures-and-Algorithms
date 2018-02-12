import java.util.Stack;

public class RPNCalc {
    private String input = "15 7 1 1 + - / 3 * 2 1 1 + + -";//inputs are seperated via spaces
    private Stack<Integer> stack = new Stack<>();

    public void SetInput(String newInput){
        input = newInput;
    }

    public boolean validateInput(){
        String[] splitInput = input.split(" ");
        try {
            for (String aSplitInput : splitInput) {
                switch (aSplitInput) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        stack.push(stack.pop() / stack.pop());
                        break;
                    default:
                        int temp = Integer.parseInt(aSplitInput);
                        stack.push(temp);
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

