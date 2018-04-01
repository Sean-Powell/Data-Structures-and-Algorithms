import java.util.Scanner;

class BinaryTree {
    private Scanner scan = new Scanner(System.in);

    private boolean firstNode = true;
    private Node rootNode = null;

    void start() {
        boolean run = true;
        while (run) {
            try {
                System.out.println("Enter 1 to add to the tree, Enter 2 to find if a number is in the tree. -1 to quit");
                int input = scan.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Enter anything other than a number to stop entering numbers");
                        while (true) {
                            try {
                                System.out.println("Enter an integer: ");
                                addNode(scan.nextInt());
                            } catch (Exception ignore) {
                                scan = null;
                                scan = new Scanner(System.in);
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter the number you wish to find in the list");
                        input = scan.nextInt();
                        if (findNode(input, rootNode)) {
                            System.out.println("There is a node in the tree with that data");
                        } else {
                            System.out.println("A node with that data could not be found in the tree");
                        }
                        break;
                    case -1:
                        printTree(rootNode);
                        run = false;
                        break;
                    default:
                        System.out.println("invalid input");
                }
            } catch (Exception ignore) {
                scan = null;
                scan = new Scanner(System.in);
            }
        }
    }

    private boolean findNode(int _input, Node _nodeBeingChecked) {
        if (_nodeBeingChecked == null) {//checks if node being checked is equal to null
            return false;
        } else if (_input == _nodeBeingChecked.getData()) {//checks if the nodes data is equal to the search
            return true;
        } else {//the traversals also check if the node that is being traversed to are equal to null. If they are the data is not in the tree.
            if (_nodeBeingChecked.getData() >= _input) { //if the data is larger than the input it will traverse to the right
                return _nodeBeingChecked.getRightNode() != null && findNode(_input, _nodeBeingChecked.getRightNode());
            } else {//otherwise it will traverse to the left
                return _nodeBeingChecked.getLeftNode() != null && findNode(_input, _nodeBeingChecked.getLeftNode());
            }
        }
    }


    private void printTree(Node _node) {
        if (_node == null) {
            return;
        }
        System.out.print("Data: " + _node.getData() + " Left Node: ");
        if (_node.getLeftNode() != null) {
            System.out.print(_node.getLeftNode().getData());
        } else {
            System.out.print("null");
        }
        System.out.print(" Right node: ");
        if (_node.getRightNode() != null) {
            System.out.print(_node.getRightNode().getData());
        } else {
            System.out.print("null");
        }
        System.out.println();

        printTree(_node.getLeftNode());
        printTree(_node.getRightNode());
    }

    private void addLeftNode(Node _oldNode, int _data) {
        if (_oldNode.getLeftNode() != null) {
            Node leftNode = _oldNode.getLeftNode();
            if (_data >= leftNode.getData()) {
                addRightNode(leftNode, _data);
            } else {
                addLeftNode(leftNode, _data);
            }
        } else {
            _oldNode.setLeftNode(new Node(_data, null, null));
        }
    }

    private void addRightNode(Node _oldNode, int _data) {
        if (_oldNode.getRightNode() != null) {
            Node rightNode = _oldNode.getRightNode();
            if (_data >= rightNode.getData()) {
                addRightNode(rightNode, _data);
            } else {
                addLeftNode(rightNode, _data);
            }
        } else {
            _oldNode.setRightNode(new Node(_data, null, null));
        }
    }

    private void addNode(int _input) {
        if (firstNode) {
            firstNode = false;
            rootNode = new Node(_input, null, null);
        } else {
            if (_input >= rootNode.getData()) {
                addRightNode(rootNode, _input);
            } else {
                addLeftNode(rootNode, _input);
            }
        }
    }
}