import java.util.ArrayList;
import java.util.Scanner;

class BinaryTree {
    private ArrayList<Integer> listOfInts = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    void start(){
        getUserInputs();
        if(listOfInts.size() != 0){
            makeTree(listOfInts);
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
            Node leftNode = oldNode.getLeftNode();
            if(data >= leftNode.getData()){
                addRightNode(leftNode, data);
            }else{
                addLeftNode(leftNode, data);
            }
        }else{
            oldNode.setLeftNode(new Node(data, null, null));
        }
    }

    private void addRightNode(Node oldNode, int data){
        if(oldNode.getRightNode() != null){
            Node rightNode = oldNode.getRightNode();
            if(data >= rightNode.getData()){
                addRightNode(rightNode, data);
            }else{
                addLeftNode(rightNode, data);
            }
        }else{
            oldNode.setRightNode(new Node(data, null, null));
        }
    }

    private void makeTree(ArrayList<Integer> list){
        int value;
        int mid = list.size() / 2;

        value = list.get(mid);
        list.remove(mid);

        Node rootNode = new Node(value, null, null);

        for (Integer aList : list) {
            value = aList;
            if (value >= rootNode.getData()) { //go to the right branch
                addRightNode(rootNode, value);
            } else {
                addLeftNode(rootNode, value);
            }
        }

        System.out.println("Tree made");
    }
}
