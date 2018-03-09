class MultiNumber {
    /*
    This is a object that is used in the PairMatrix class. It stores the product of two numbers as well as its two factors
    it also has 3 methods defined to return both the factors and the product. When creating a new MultiNumber then you need
    to pass both the factors and the resultant product.
     */
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
