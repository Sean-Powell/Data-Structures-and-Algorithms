class Node {
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
