import java.util.ArrayList;

/*
This is a merge sort implementation that is made to sort through the products in the MultiNumber arrays that are passed
to it.
 */
class MergeSort {
    ArrayList<MultiNumber> mergeSort(ArrayList<MultiNumber> _list){
        assert  _list != null;

        if(_list.size() <= 1){
            return _list;
        }
        int halfSize = (int) Math.ceil(_list.size() / 2);
        ArrayList<MultiNumber> leftSide = new ArrayList<>();
        ArrayList<MultiNumber> rightSide = new ArrayList<>();
        int currentNumIndex = 0;
        for (MultiNumber aList : _list) {
            if (currentNumIndex < halfSize) {
                leftSide.add(aList);
                currentNumIndex++;
            } else {
                rightSide.add(aList);
            }
        }

        leftSide = mergeSort(leftSide);
        rightSide = mergeSort(rightSide);

        return mergeLists(leftSide, rightSide);
    }

    private ArrayList<MultiNumber> mergeLists(ArrayList<MultiNumber> _list1, ArrayList<MultiNumber> _list2){
        assert _list1 != null && _list2 != null;

        ArrayList<MultiNumber> result = new ArrayList<>();
        while(!_list1.isEmpty() && !_list2.isEmpty()){
            MultiNumber num1 = _list1.get(0);
            MultiNumber num2 = _list2.get(0);
            if(num1.getProduct() < num2.getProduct()){
                result.add(num1);
                _list1.remove(0);
            }else{
                result.add(num2);
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
