import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne1() {
        boolean res = offByOne.equalChars('%', '&');
        boolean actual = true;
        assertEquals(res, actual);
    }
    @Test
    public void testOffByOne2() {
        boolean res = offByOne.equalChars('A', 'b');
        boolean actual = false;
        assertEquals(res, actual);
    }
    @Test
    public void testOffByOne3() {
        boolean res = offByOne.equalChars('a', 'b');
        boolean actual = true;
        assertEquals(res, actual);
    }
    @Test
    public void testOffByOne4() {
        boolean res = offByOne.equalChars('b', 'a');
        boolean actual = true;
        assertEquals(res, actual);
    }

    @Test
    public void testOffByOne5() {
        boolean res2 = offByOne.equalChars('a', 'c');
        boolean actual2 = false;
        assertEquals(res2, actual2);
    }


}
