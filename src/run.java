import javax.swing.plaf.synth.SynthEditorPaneUI;

public class run {
    private static RPNCalc rpnc = new RPNCalc();
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        System.out.println(rpnc.validateInput());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken in milliseconds: " + (endTime - startTime));
    }
}
