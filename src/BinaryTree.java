import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTree {
    private ArrayList<Integer> listOfInts = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    void start(){
        getUserInputs();
        if(listOfInts.size() != 0){
            System.out.println(listOfInts.toString());
            listOfInts = mergeSort(listOfInts);
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

    private ArrayList<Integer> mergeSort(@NotNull ArrayList<Integer> list){
        if(list.size() <= 1){
            return list;
        }
        int halfSize = (int) Math.ceil(list.size() / 2);
        ArrayList<Integer> leftSide = new ArrayList<>();
        ArrayList<Integer> rightSide = new ArrayList<>();
        int j = 0;
        for (Integer aList : list) {
            if (j < halfSize) {
                leftSide.add(aList);
                j++;
            } else {
                rightSide.add(aList);
            }
        }

        leftSide = mergeSort(leftSide);
        rightSide = mergeSort(rightSide);

        return mergeLists(leftSide, rightSide);
    }

    private ArrayList<Integer> mergeLists(@NotNull ArrayList<Integer> list1, @NotNull ArrayList<Integer> list2){
        ArrayList<Integer> result = new ArrayList<>();
        while(!list1.isEmpty() && !list2.isEmpty()){
            if(list1.get(0) < list2.get(0)){
                result.add(list1.get(0));
                list1.remove(0);
            }else{
                result.add(list2.get(0));
                list2.remove(0);
            }
        }

        while(!list1.isEmpty()){
            result.add(list1.get(0));
            list1.remove(0);
        }

        while(!list2.isEmpty()){
            result.add(list2.get(0));
            list2.remove(0);
        }
        return result;
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
