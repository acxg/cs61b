public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int dif = x - y;
        if (Math.abs(dif) == 1) {
            return true;
        } else {
            return false;
        }
    }

}
