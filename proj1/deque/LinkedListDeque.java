package deque;

public class LinkedListDeque<T> implements Deque<T>{
    private DNode sentinel;
    private int size;
    private class DNode {
        public T item;
        public DNode prev;
        public DNode next;
        public DNode(T i, DNode p, DNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    public LinkedListDeque() {
        sentinel = new DNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(T item) {
        sentinel = new DNode(null,null,null);
        sentinel.next = new DNode(item,sentinel,sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }
    public void addFirst(T item) {
        DNode temp = new DNode(item,sentinel,sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size += 1;
    }
    public void addLast(T item) {
        DNode temp = new DNode(item,sentinel.prev,sentinel);
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
        if ((this.isEmpty()) || (index >= size)){
            return null;
        }
        DNode temp = sentinel.next;
        while (index != 0) {
            temp = temp.next;
            index -= 1;
        }
        return temp.item;
    }
}