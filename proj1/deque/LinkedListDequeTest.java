package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import java.util.Iterator;
import java.util.Optional;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
    @Test
    public void iteratorTest4AD() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < 70; i++) {
            arrayDeque.addLast(i);
        }

        int index = 0;
        for (int item : arrayDeque) {
            assertEquals(index, item);
            index += 1;
        }
    }
    @Test
    public void equalsATestEqual() {
        Deque<Integer> L = new LinkedListDeque<>();
        Deque<Integer> A = new ArrayDeque<>();
        int N1 = 100;
        for (int i = 0; i < N1; i++) {
            int randVal = StdRandom.uniform(0,100);
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                L.addLast(randVal);
                A.addLast(randVal);
            } else if (operationNumber == 1) {
                L.addFirst(randVal);
                A.addFirst(randVal);
            }
            assertEquals(L.size(),A.size());
        }
        boolean AEqualsL = A.equals(L);
        boolean LEqualsA = L.equals(A);
        assertTrue(AEqualsL);
        assertTrue(LEqualsA);
        L.removeFirst();
        AEqualsL = A.equals(L);
        LEqualsA = L.equals(A);
        assertFalse(AEqualsL);
        assertFalse(LEqualsA);
        L.addFirst(999);
        AEqualsL = A.equals(L);
        LEqualsA = L.equals(A);
        assertFalse(AEqualsL);
        assertFalse(LEqualsA);
    }
    @Test
    public void addResizeTest2() {
        Deque<Integer> A = new ArrayDeque<>();
        int N1 = 7;
        int N2 = 9;
        for (int i = 0; i < N1; i++) {
            int randVal = StdRandom.uniform(0,100);
            A.addFirst(randVal);
        }
        for (int i = 0; i < N2; i++) {
            int randVal = StdRandom.uniform(0,100);
            A.addLast(randVal);
        }
        A.addFirst(999);
    }
    @Test
    public void addResizeTest3() {
        Deque<Integer> A = new ArrayDeque<>();
        int N1 = 7;
        int N2 = 9;
        for (int i = 0; i < N1; i++) {
            int randVal = StdRandom.uniform(0,100);
            A.addFirst(randVal);
        }
        for (int i = 0; i < N2; i++) {
            int randVal = StdRandom.uniform(0,100);
            A.addLast(randVal);
        }
        A.addLast(999);
    }
    @Test
    public void addResizeTest() {
        Deque<Integer> L = new LinkedListDeque<>();
        Deque<Integer> A = new ArrayDeque<>();
        int N1 = 100;
        for (int i = 0; i < N1; i++) {
            int randVal = StdRandom.uniform(0,100);
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                L.addLast(randVal);
                A.addLast(randVal);
            } else if (operationNumber == 1) {
                L.addFirst(randVal);
                A.addFirst(randVal);
            }
            assertEquals(L.size(),A.size());
        }
        for (int i = 0; i < N1; i++) {
            int ithA = A.get(i);
            int ithL = L.get(i);
            assertEquals(ithA,ithL);
        }
    }
    @Test
    public void addResizeBackTest() {
        Deque<Integer> L = new LinkedListDeque<>();
        Deque<Integer> A = new ArrayDeque<>();
        int N1 = 100;
        for (int i = 0; i < N1; i++) {
            int randVal = StdRandom.uniform(0,100);
            L.addLast(randVal);
            A.addLast(randVal);
            assertEquals(L.size(),A.size());
        }
        for (int i = 0; i < N1; i++) {
            assertEquals(A.get(i),L.get(i));
        }
    }
    @Test
    public void removeResizeTest() {
        Deque<Integer> L = new LinkedListDeque<>();
        Deque<Integer> A = new ArrayDeque<>();
        int N1 = 100;
        for (int i = 0; i < N1; i++) {
            int operationNumber = StdRandom.uniform(0, 2);
            int randVal = StdRandom.uniform(0,100);
            if (operationNumber == 0) {
                L.addLast(randVal);
                A.addLast(randVal);
            } else if (operationNumber == 1) {
                L.addFirst(randVal);
                A.addFirst(randVal);
            }
            assertEquals(L.size(),A.size());
        }
        for (int i = 0; i < N1; i++) {
            int operationNumber = StdRandom.uniform(0,2);
            if (operationNumber == 0) {
                int removedA = A.removeLast();
                int removedL = L.removeLast();
                assertEquals(removedA,removedL);
            } else if (operationNumber == 1) {
                int removedA = A.removeFirst();
                int removedL = L.removeFirst();
                assertEquals(removedA,removedL);
            }
        }
    }
    @Test
    public void getLinkedListTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            L.addLast(i);
        }
        int index = 0;
        for (int i = 0; i < 10; i++) {
            int L1 = L.getRecursive(i);
            int L2 = L.get(i);
            assertEquals(i, L1);
            assertEquals(i, L2);
        }
    }
    @Test
    public void hasNextArrayDequeTest() {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            A.addLast(i);
        }
        Iterator<Integer> seerA = A.iterator();
        for (int i = 0; i < 19; i++) {
           boolean shouldHasNext = seerA.hasNext();
           seerA.next();
           assertTrue(shouldHasNext);
        }
        boolean shouldNotHasNext = seerA.hasNext();
        assertFalse(shouldNotHasNext);
    }
    @Test
    public void hasNextArrayEmptyDequeTest() {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        Iterator<Integer> seerA = A.iterator();
        boolean shouldNotHasNext = seerA.hasNext();
        assertFalse(shouldNotHasNext);
    }
    @Test
    public void randomizedTest() {
        Deque<Integer> L = new LinkedListDeque<>();
        Deque<Integer> A = new ArrayDeque<>();

        int N2 = 10000000;
        for (int i = 0; i < N2; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                A.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeA = A.size();
                assertEquals(sizeL,sizeA);
            } else if (operationNumber == 2) {
                //removeLast
                if (L.size() == 0) {
                    continue;
                }
                else {
                    int lastL = L.removeLast();
                    int lastA = A.removeLast();
                    assertEquals(lastL,lastA);
                }
            } else if (operationNumber == 3) {
                //getLast
                if (L.size() == 0) {
                    continue;
                } else {
                    assertEquals(L.size(),A.size());
                    int randIndex = StdRandom.uniform(0,L.size());
                    int lastL = L.get(randIndex);
                    int lastA = A.get(randIndex);
                    assertEquals(lastA,lastL);
                }
            } else if (operationNumber == 4) {
                //addFirst
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                A.addLast(randVal);
            } else if (operationNumber == 5) {
                //removeFirst
                if (L.size() == 0) {
                    continue;
                }
                else {
                    int lastL = L.removeFirst();
                    int lastB = A.removeFirst();
                    assertEquals(lastL,lastB);
                }
            }

        }
    }
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        ArrayDeque<String> lld2 = new ArrayDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");
        lld2.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertEquals(1, lld2.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
        lld2.addFirst("middle");
		assertEquals(2, lld1.size());
        assertEquals(2, lld2.size());

		lld1.addLast("back");
        lld2.addLast("back");
		assertEquals(3, lld1.size());
        assertEquals(3, lld2.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
        lld2.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }
}
