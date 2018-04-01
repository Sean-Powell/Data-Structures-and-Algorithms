public class HashPair {
    private byte hash[];
    private int number;

    HashPair(byte _hash[], int _number){
        hash = _hash;
        number = _number;
    }

    public byte[] getHash() {
        return hash;
    }

    public int getNumber() {
        return number;
    }
}
