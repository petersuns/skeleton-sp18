import static org.junit.Assert.*;

import org.junit.Test;

public class IntListTest {

    /**
     * Example test that verifies correctness of the IntList.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */
    @Test
    public void testReverse(){
        IntList input_null = null;

        IntList one = new IntList(3, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(1, twoOne);
        threeTwoOne.first=4;
        IntList reversed = IntList.reverse(threeTwoOne);
        IntList reversedReversed = IntList.reverse(reversed);
        System.out.println("test when inout = null");
        System.out.println(IntList.reverse(threeTwoOne));
        System.out.println("test if size() works");
        System.out.println(IntList.size(threeTwoOne,0));
        System.out.println(IntList.size(twoOne,0));
        System.out.println(IntList.size(one,0));
//        assertEquals(IntList.size(threeTwoOne,0) , 3);

        System.out.println("test if reverse() works");
//        System.out.println(reversed.first);
//        System.out.println(reversed.rest.first);
//        System.out.println(reversed.first);


//        assertEquals(threeTwoOne.first, reversed.rest.rest.first);
        assertEquals(reversed.rest.rest.rest, null);

    }

    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.of(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList L = IntList.of(1, 2, 3);
        IntList.dSquareList(L);
        assertEquals(IntList.of(1, 4, 9), L);
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.of method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty list, which
     * can be instantiated, for example, with
     * IntList empty = IntList.of().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        IntList L = IntList.of(1, 2, 3);
        IntList res = IntList.squareListRecursive(L);
        assertEquals(IntList.of(1, 2, 3), L);
        assertEquals(IntList.of(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.dcatenate(A, B));
        assertEquals(IntList.of(1, 2, 3, 4, 5, 6), A);
    }

    @Test
    public void testCatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.catenate(A, B));
        assertEquals(IntList.of(1, 2, 3), A);
    }

    /** If you're running this from the command line, you'll need
      * to add a main method. See ArithmeticTest.java for an
      * example. */

}
