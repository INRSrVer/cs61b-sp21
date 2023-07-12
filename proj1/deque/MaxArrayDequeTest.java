package deque;


import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;
public class MaxArrayDequeTest {
    private static class IntComparator implements Comparator<Integer> {
        public int compare(Integer num1,Integer num2) {
            return num1 - num2;
        }
    }
    @Test
    public void ComparatorTest() {
        MaxArrayDeque<Integer> dq1 = new MaxArrayDeque<>(new IntComparator());
        dq1.addLast(114);
        dq1.addLast(514);
        dq1.addLast(1919);
        dq1.addLast(810);

        assertEquals((Integer) 1919, dq1.max());
        assertEquals((Integer) 1919, dq1.max(new IntComparator()));
    }
}
