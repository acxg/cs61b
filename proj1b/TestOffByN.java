import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    OffByN offBy5 = new OffByN(5);

    // Your tests go here.
    @Test
    public void testOffByOne1() {
        boolean res = offBy5.equalChars('f', 'h');
        boolean actual = false;
        assertEquals(res, actual);
    }

    @Test
    public void testOffByOne2() {
        boolean res2 = offBy5.equalChars('a','f');
        boolean actual2 = true;
        assertEquals(res2, actual2);
    }


}
