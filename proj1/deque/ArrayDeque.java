package deque;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int cap;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[16];
        size = 0;
        cap = 16;
        nextFirst = 6;
        nextLast = 7;
    }

    private void resizeCheck() {
        if (size == cap) {
            resizeLarger();
        } else if ((cap > 16) && (size < cap / 4)) {
            resizeSmaller();
        }
    }

    private void resizeLarger() {
        T[] a = (T[]) new Object[cap * 2];
        int firstOne = pointerForward(nextFirst);
        int lastOne = pointerBackward(nextLast);
        if (firstOne == 0) {
            System.arraycopy(items, 0, a, 0, size);
            items = a;
            cap *= 2;
            nextLast = nextFirst + 1;
            nextFirst = cap - 1;
        } else {
            System.arraycopy(items, 0, a, 0, lastOne + 1);
            System.arraycopy(items, firstOne, a, firstOne + size, cap - lastOne -1);
            items = a;
            cap *= 2;
            nextFirst = size + nextFirst;
        }

    }
    private void resizeSmaller() {
        T[] a = (T[]) new Object[cap / 2];
        int firstOne = pointerForward(nextFirst);
        int lastOne = pointerBackward(nextLast);
        if (nextLast > nextFirst) {
            System.arraycopy(items, nextFirst + 1, a, 0, size);
            nextFirst = cap / 2 - 1;
            nextLast = size;
        } else if (nextLast < nextFirst) {
            System.arraycopy(items, 0, a, 0, nextLast);
            System.arraycopy(items, nextFirst + 1, a, nextFirst + 1 - cap / 2, cap - nextFirst - 1);
            nextFirst = nextFirst - cap / 2;
        }
        items = a;
        cap /= 2;
    }

    ;

    private int pointerBackward(int i) {
        if (i == 0) {
            return cap - 1;
        } else {
            return i - 1;
        }
    }

    private int pointerForward(int i) {
        if (i == cap - 1) {
            return 0;
        } else {
            return i + 1;
        }
    }

    @Override
    public void addFirst(T item) {
        resizeCheck();
        items[nextFirst] = item;
        nextFirst = pointerBackward(nextFirst);
        size += 1;
    }

    @Override
    public void addLast(T item) {
        resizeCheck();
        items[nextLast] = item;
        nextLast = pointerForward(nextLast);
        size += 1;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        int firstOne = pointerForward(nextFirst);
        while (firstOne != nextLast) {
            System.out.print(items[firstOne] + " ");
            firstOne = pointerForward(firstOne);
        }
        System.out.print("\n");

    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = pointerForward(nextFirst);
        T item = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        resizeCheck();
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = pointerBackward(nextLast);
        T item = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        resizeCheck();
        return item;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        int pointer = pointerForward(nextFirst);
        while (index != 0) {
            pointer = pointerForward(pointer);
            index -= 1;
        }
        return items[pointer];
    }

}
