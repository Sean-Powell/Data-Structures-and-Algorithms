import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

class MergeSort {
    ArrayList<Integer> mergeSort(@NotNull ArrayList<Integer> list){
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
}
