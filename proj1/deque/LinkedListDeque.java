package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private final DNode sentinel;
    private int size;
    private class DNode {
        private final T item;
        private DNode prev;
        private DNode next;
        public DNode(T i, DNode p, DNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    public LinkedListDeque() {
        sentinel = new DNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(T item) {
        sentinel = new DNode(null, null, null);
        sentinel.next = new DNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }
    public void addFirst(T item) {
        DNode temp = new DNode(item, sentinel, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size += 1;
    }
    public void addLast(T item) {
        DNode temp = new DNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size += 1;
    }
    public int size() {
        return this.size;
    }
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        DNode temp = sentinel.next;
        while (temp.next != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        DNode temp = sentinel.next.next;
        T item = sentinel.next.item;
        temp.prev = sentinel;
        sentinel.next = temp;
        size -= 1;
        return item;
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        DNode temp = sentinel.prev.prev;
        T item = sentinel.prev.item;
        sentinel.prev = temp;
        temp.next = sentinel;
        size -= 1;
        return item;
    }
    public T get(int index) {
        if ((this.isEmpty()) || (index >= size)) {
            return null;
        }
        DNode temp = sentinel.next;
        while (index != 0) {
            temp = temp.next;
            index -= 1;
        }
        return temp.item;
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private DNode wizPos;

        LinkedListDequeIterator() {
            wizPos = sentinel.next;
        }

        public boolean hasNext() {
            return wizPos.next != sentinel;
        }

        public T next() {
            T returnItem = wizPos.item;
            wizPos = wizPos.next;
            return returnItem;
        }
    }
    public boolean equals(Object o) {
        if (o instanceof Deque) {
            if (this.size != ((Deque<?>) o).size()) {
                return false;
            }
            Deque<T> o1 = (Deque<T>) o;
            for (int i = 0; i < this.size(); i++) {
                if (o1.get(i) != this.get(i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    //the following part is OK in the local test but unable to compile in the AutoGrader
    /*
    public boolean equals(Object o) {
        if (o instanceof Deque) {
            if (this.size != ((Deque<?>) o).size()) {
                return false;
            }
            Deque<T> o1 = (Deque<T>) o;
            Iterator<T> seerA = this.iterator();
            Iterator<T> seerB = o1.iterator();
            while (seerA.hasNext()) {
                T AItem = seerA.next();
                T BItem = seerB.next();
                if (AItem != BItem) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
     */
}