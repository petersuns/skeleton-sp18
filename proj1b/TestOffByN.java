import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(5);

    // Your tests go here.
    @Test
    public void TestOffByN(){
//        OffByN obo = new OffByOne(5);
////        System.out.println(obo.equalChars('a', 'b'));
////        System.out.println(obo.equalChars('b', 'a'));
//        assertTrue(obo.equalChars('a', 'b'));
//        assertFalse(obo.equalChars('a', 'B'));
//
//        assertTrue(obo.equalChars('r', 'q'));
//        assertTrue(obo.equalChars('&', '%'));

        OffByN offBy5 = new OffByN(5);
        System.out.println(offBy5.equalChars('a', 'f'));  // true
        System.out.println(offBy5.equalChars('f', 'a'));  // true
        System.out.println(offBy5.equalChars('f', 'h'));  // false
    }


}