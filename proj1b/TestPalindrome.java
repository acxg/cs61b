import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean res = palindrome.isPalindrome("a");
        boolean actual = true;
        assertEquals(res, actual);

        boolean res2 = palindrome.isPalindrome("cat");
        boolean actual2 = false;
        assertEquals(res2,actual2);

        boolean res3 = palindrome.isPalindrome("racecar");
        boolean actual3 = true;
        assertEquals(res3, actual3);

    }

    @Test
    public void testNewIsPalindrome() {
        boolean res = palindrome.isPalindrome("flake", new OffByOne());
        boolean actual = true;
        assertEquals(res, actual);
    }

    @Test
    public void testNewIsPalindrome2() {
        boolean res = palindrome.isPalindrome("aba", new OffByOne());
        boolean actual = false;
        assertEquals(res, actual);
    }

    @Test
    public void testNewIsPalindrome3() {
        boolean res = palindrome.isPalindrome("bcd", new OffByOne());
        boolean actual = false;
        assertEquals(res, actual);
    }

    @Test
    public void testNewIsPalindrome4() {
        boolean res = palindrome.isPalindrome("b", new OffByOne());
        boolean actual = true;
        assertEquals(res, actual);
    }
}
