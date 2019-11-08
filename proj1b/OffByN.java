public class OffByN implements CharacterComparator {
    public int byN;
    public OffByN(int N){
        byN = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int dif = x - y;
        if (Math.abs(dif) == byN) {
            return true;
        } else {
            return false;
        }
    }
}
