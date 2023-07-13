package deque;


import java.util.Comparator;
import java.util.Iterator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxItem = get(0);
        Iterator<T> seerA = super.iterator();
        while (seerA.hasNext()) {
            T nextItem = seerA.next();
            if (c.compare(nextItem, maxItem) > 0) {
                maxItem = nextItem;
            }
        }
        return maxItem;
    }
    public T max() {
        return max(comparator);
    }

    /*
    @Override
    private boolean equals(Object o) {
        return false;
    }
     */
}
