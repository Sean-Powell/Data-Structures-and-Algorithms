class Node {
    /*
    This is the method that outlines the behaviour of the node for the BinaryTree. Each node has references to two more
    nodes, a right node and a left node. It also stores a data value. When creating a new node you need to pass the data
    and information on the left and right node if these nodes do not exist then it should be set to null. There is also
    methods that have been defined to get the left and right node and the data that is stored in the node. There is also
    the methods for setting the right and left node.
     */
    private Node leftNode;
    private Node rightNode;
    private int data;
    Node(int _data, Node _leftNode, Node _rightNode){
        data = _data;
        rightNode = _rightNode;
        leftNode = _leftNode;
    }

    void setLeftNode(Node _node){
        leftNode = _node;
    }

    void setRightNode(Node _node){
        rightNode = _node;
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
