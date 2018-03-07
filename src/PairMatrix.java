import java.util.ArrayList;

class PairMatrix {
    private ArrayList<MultiNumber> LIST;
    private MergeSort MS = new MergeSort();//creates an instance of the Mergesort class
    private int pairsFound;//Counter for holding the number of pairs found

    private final int LIST_SIZE = 1024; //stores the size of the list

    void start() {
        pairsFound = 0;//Sets the pairsFound counter to 0
        LIST = new ArrayList<>();//creates the list that will be populated with the total list of products and factors
        long start = System.currentTimeMillis();//gets the time the operation starts
        populateList();//creates the list of products and factors and stores them in the above list
        findPairs();//finds the pairs of numbers and outputs them.
        System.out.println("Pairs Found: " + pairsFound); //outputs the number of pairs found
        long end = System.currentTimeMillis(); //finds the time the operation ended at
        System.out.printf("Time taken: %d\n", ((end - start) / 1000)); //outputs the time it took in seconds to finish
    }

    private void populateList() {
        /*
         1
         1 2
         1 2 3
         1 2 3 4
         1 2 3 4 5

         On line n after the nth element in that line the products are then repeated. We can use this fact to reduce
         the number of products to be checked from 1024^2 to the summation of 1 to 1024
         */
        for (int i = 0; i < LIST_SIZE; i++) {
            for (int j = 0; j <= i; j++) {
                MultiNumber num = new MultiNumber((i + 1), (j + 1), ((i + 1) * (j + 1)));
                LIST.add(num);
            }
        }
    }

    private boolean checkFactors(MultiNumber _num1, MultiNumber _num2) {//returns false if they match
        //Gets and stores the 4 factors.
        int factor1, factor2, factor3, factor4;
        factor1 = _num1.getFactor1();
        factor2 = _num1.getFactor2();
        factor3 = _num2.getFactor1();
        factor4 = _num2.getFactor2();

        //compares all the factors to make sure none of them match
        return factor1 != factor2 && factor1 != factor3 && factor1 != factor4 && factor2 != factor3 && factor2 != factor4 && factor3 != factor4;
    }

    //find first num of same num
    //find last num of that num;
    //Check for pairs between the 2 found index
    //print pairs

    private void findPairs() {
        /*
        Sorting the list with MergeSort first allows us to further optimise the process via, finding the block of products
        that are the same, allows the process to search only against that block of products instead of the entire list of products
        this drastically
         */
        LIST = MS.mergeSort(LIST); //This sorts the list using MergeSort.
        //LIST.sort(Comparator.comparingInt(MultiNumber::getProduct)); //This was previously used however default search methods are not allowed

        int firstNumIndex, lastNumIndex = 0, currentNum = 0; //Variables to hold the first and final index of the block and the blocks value
        MultiNumber num1, num2;// variables for holding the two MultiNumber objects being compared to reduce ArrayList calls.
        int i = 0;
        try {//it is surrounded by a try catch block to catch any potential errors that can occur during the logic the
             //exception is then ignored.
            while (i < LIST.size()) {//loop through till the end of the list
                /*
                checks if the currents numbers product is different from the one stored in currentNum
                this is always the case the first time as the number is set to 0
                 */
                if (LIST.get(i).getProduct() != currentNum) {
                    firstNumIndex = i;//the index at which the new block of numbers starts
                    lastNumIndex = i;//the index at which the block ends it is assumed to be the same as the start
                    /*
                    The list is then incremented until there is an different number at the lastNumIndex + 1
                    if the number is the same the lastNumIndex is incremented. This is surrounded in a try catch block
                    in case when incrementing the new index is out of the ArrayLists bounds. This exception is ignored.
                     */
                    try {
                        if (LIST.get(lastNumIndex + 1).getProduct() == currentNum) {
                            lastNumIndex++;
                        }
                    } catch (Exception ignore) {

                    }
                    /*
                    The program then loops through this block trying all the combinations against each other to see if
                    the possible pairs match the criteria. If it does match the criteria then it prints out the output to
                    the console.
                     */
                    for (int j = firstNumIndex; j <= lastNumIndex; j++) {
                        num1 = LIST.get(j);
                        for (int k = firstNumIndex; k <= lastNumIndex; k++) {
                            if (j == k && (k + 1) > lastNumIndex) {
                                k++;
                            }
                            num2 = LIST.get(k);
                            if (checkFactors(num1, num2) && num1.getProduct() == num2.getProduct()) {
                                System.out.println("(" + num1.getFactor1() + "*" + num1.getFactor2() + ")and(" + num2.getFactor1() + "*" + num2.getFactor2() + ")" + " = " + num1.getProduct());
                                pairsFound++;
                            }
                        }
                    }
                }
                i = lastNumIndex;//This sets i to the lastNumIndex, so as not to recheck part of a number block
                i++;//i is then incremented.
            }
        }catch (Exception ignore){

        }
    }
}