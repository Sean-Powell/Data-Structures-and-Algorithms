import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

class MergeSort {
    ArrayList<MultiNumber> mergeSort(@NotNull ArrayList<MultiNumber> _list){
        if(_list.size() <= 1){
            return _list;
        }
        int halfSize = (int) Math.ceil(_list.size() / 2);
        ArrayList<MultiNumber> leftSide = new ArrayList<>();
        ArrayList<MultiNumber> rightSide = new ArrayList<>();
        int j = 0;
        for (MultiNumber aList : _list) {
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

    private ArrayList<MultiNumber> mergeLists(@NotNull ArrayList<MultiNumber> _list1, @NotNull ArrayList<MultiNumber> _list2){
        ArrayList<MultiNumber> result = new ArrayList<>();
        while(!_list1.isEmpty() && !_list2.isEmpty()){
            if(_list1.get(0).getProduct() < _list2.get(0).getProduct()){
                result.add(_list1.get(0));
                _list1.remove(0);
            }else{
                result.add(_list2.get(0));
                _list2.remove(0);
            }
        }

        while(!_list1.isEmpty()){
            result.add(_list1.get(0));
            _list1.remove(0);
        }

        while(!_list2.isEmpty()){
            result.add(_list2.get(0));
            _list2.remove(0);
        }
        return result;
    }
}
