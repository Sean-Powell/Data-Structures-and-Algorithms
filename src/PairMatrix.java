import java.util.ArrayList;
import java.util.Comparator;

public class PairMatrix{
    private ArrayList<MultiNumber> LIST = new ArrayList<>();

    public void start(){
        populateList();
        findPairs();
    }

    private void populateList(){
        for(int i = 0; i < 1024; i++){
            for(int j = 0; j <= i; j++){
                MultiNumber num = new MultiNumber((i + 1), (j + 1), ((i + 1) * (j + 1)));
                LIST.add(num);
            }
        }
    }
    private boolean checkFactors(MultiNumber num1, MultiNumber num2){
        int factor1, factor2, factor3, factor4;

        factor1 = num1.getFactor1();
        factor2 = num1.getFactor2();
        factor3 = num2.getFactor1();
        factor4 = num2.getFactor2();

        return factor1 != factor2 && factor1 != factor3 && factor1 != factor4 && factor2 != factor3 && factor2 != factor4 && factor3 != factor4;
    }

    //find first num of same num
    //find last num of that num;
    //Check for pairs between the 2 found index
    //print pairs

    private void findPairs(){
        LIST.sort(Comparator.comparingInt(MultiNumber::getProduct));
        int firstNumIndex, lastNumIndex, currentNum = 0;
        MultiNumber num1, num2;
        try{
            int i = 0;
            while(true){
                if(LIST.get(i).getProduct() != currentNum){
                    firstNumIndex = i;
                    lastNumIndex = i;
                    try{
                        if(LIST.get(lastNumIndex + 1).getProduct() == currentNum){
                            lastNumIndex++;
                        }
                    }catch(Exception ignore){

                    }

                    for(int j = firstNumIndex; j <= lastNumIndex; j++){
                        num1 = LIST.get(j);
                        for(int k = firstNumIndex; k <= lastNumIndex; k++){
                            if(j == k){
                                k++;
                            }
                            num2 = LIST.get(k);
                            if(checkFactors(num1, num2)){
                                System.out.println("("+num1.getFactor1()+"*"+num1.getFactor2()+")and("+num2.getFactor1()+"*"+num2.getFactor2()+")");
                            }
                        }
                    }
                }
                i++;
            }
        }catch (Exception ignored){
            //Ignore the exception
        }
    }
}