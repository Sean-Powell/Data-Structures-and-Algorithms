import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTree {
    private ArrayList<Integer> listOfInts = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private MergeSort MS = new MergeSort();

    void start(){
        getUserInputs();
        if(listOfInts.size() != 0){
            System.out.println(listOfInts.toString());
            listOfInts = MS.mergeSort(listOfInts);
            System.out.println(listOfInts.toString());
            createBinaryTree(listOfInts);
        }else{
            System.err.println("The user inputted no integers");
        }
    }

    private void createBinaryTree(ArrayList<Integer> list){
        int midpoint = (int) Math.ceil(list.size() / 2);
        Node baseNode = new Node(list.get(midpoint), null, null);
        Node currentNode = baseNode;
        for(int i = midpoint - 1; i > 0; i--){
            while (true) {
                if (currentNode.getLeftNode() == null) {
                    addLeftNode(currentNode, list.get(i));
                    break;
                } else {
                    currentNode = currentNode.getLeftNode();
                }
            }
        }
        currentNode = baseNode;
        for(int i = midpoint; i < list.size(); i++){
            while(true) {
                if (currentNode.getRightNode() == null) {
                    addRightNode(currentNode, list.get(i));
                    break;
                } else {
                    currentNode = currentNode.getRightNode();
                }
            }
        }
    }

    private void getUserInputs(){
        System.out.println("Enter anything other than a number to stop entering numbers");
        while(true){
            try{
                System.out.println("Enter an integer: ");
                listOfInts.add(scan.nextInt());
            }catch(Exception e){
                break;
            }
        }
    }

    private void addLeftNode(Node oldNode, int data){
        if(oldNode.getLeftNode() != null){
            System.err.println("A left node is already on the current node");
        }else{
            oldNode.setLeftNode(new Node(data, null, null));
        }
    }

    private void addRightNode(Node oldNode, int data){
        if(oldNode.getRightNode() != null){
            System.err.println("A right node is already on the current node");
        }else{
            oldNode.setRightNode(new Node(data, null, null));
        }
    }
}
