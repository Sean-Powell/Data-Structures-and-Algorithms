class MultiNumber {
    private int factor1;
    private int factor2;
    private int product;

    MultiNumber(int _factor1, int _factor2, int _product){
        factor1 = _factor1;
        factor2 = _factor2;
        product = _product;
    }

    int getFactor1(){
        return factor1;
    }

    int getFactor2(){
        return factor2;
    }

    int getProduct(){
        return product;
    }
}
