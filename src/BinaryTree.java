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

    private void addLeftNode(Node _oldNode, int _data){
        if(_oldNode.getLeftNode() != null){
            Node leftNode = _oldNode.getLeftNode();
            if(_data >= leftNode.getData()){
                addRightNode(leftNode, _data);
            }else{
                addLeftNode(leftNode, _data);
            }
        }else{
            _oldNode.setLeftNode(new Node(_data, null, null));
        }
    }

    private void addRightNode(Node _oldNode, int _data){
        if(_oldNode.getRightNode() != null){
            Node rightNode = _oldNode.getRightNode();
            if(_data >= rightNode.getData()){
                addRightNode(rightNode, _data);
            }else{
                addLeftNode(rightNode, _data);
            }
        }else{
            _oldNode.setRightNode(new Node(_data, null, null));
        }
    }

    private void makeTree(ArrayList<Integer> _list){
        int value;
        int mid = _list.size() / 2;

        value = _list.get(mid);
        _list.remove(mid);

        Node rootNode = new Node(value, null, null);

        for (Integer aList : _list) {
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