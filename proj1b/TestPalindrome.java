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
        assertFalse(palindrome.isPalindrome("cat"));
//        System.out.println(palindrome.isPalindrome("aaa"));
//        System.out.println(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("aaa"));
        assertTrue(palindrome.isPalindrome("racecar"));
    }
    CharacterComparator cc = new OffByOne();
    @Test
    public void testIsPalindromeNew() {
        assertFalse(palindrome.isPalindrome("aaa",cc));
//        System.out.println(palindrome.isPalindrome("aaa"));
//        System.out.println(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("flake",cc));
        assertFalse(palindrome.isPalindrome("racecar",cc));
    }
}
