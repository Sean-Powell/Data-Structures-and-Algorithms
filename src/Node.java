public class Node {
    private Node leftNode;
    private Node rightNode;
    private int data;
    Node(int _data, Node _leftNode, Node _rightNode){
        data = _data;
        rightNode = _rightNode;
        leftNode = _leftNode;
    }

    void setLeftNode(Node node){
        leftNode = node;
    }

    void setRightNode(Node node){
        rightNode = node;
    }

    Node getLeftNode(){
        return leftNode;
    }

    Node getRightNode(){
        return rightNode;
    }

    int getData(){
        return data;
    }
}
