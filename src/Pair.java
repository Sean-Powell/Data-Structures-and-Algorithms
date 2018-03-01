class Pair {
    private boolean checked;
    private int value;

    Pair(int setValue){
        value = setValue;
        checked = false;
    }

    int getValue(){
        return value;
    }

    void setChecked(){
        checked = true;
    }

    boolean getChecked(){
        return checked;
    }
}
