import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestOffByOne(){
        OffByOne obo = new OffByOne();
//        System.out.println(obo.equalChars('a', 'b'));
//        System.out.println(obo.equalChars('b', 'a'));
        assertTrue(obo.equalChars('a', 'b'));
        assertFalse(obo.equalChars('a', 'B'));

        assertTrue(obo.equalChars('r', 'q'));
        assertTrue(obo.equalChars('&', '%'));
    }


}
