public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;
    private T a;

    private class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            return;
        }
        Node first = sentinel.next;
        for (int cnt = 1; cnt < size; cnt++) {
            System.out.print(first.item.toString() + ' ');
            first = first.next;
        }
        System.out.print(first.item.toString());
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T rem = sentinel.next.item;
        Node temp = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        temp = null;
        size -= 1;
        return rem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T rem = sentinel.prev.item;
        Node temp = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        temp = null;
        size -= 1;
        return rem;
    }

    public T get(int index) {
        if (size <= index) {
            return null;
        }
        Node cur = sentinel.next;
        for (int cnt = 0; cnt < index; cnt++) {
            cur = cur.next;
        }
        return cur.item;
    }

    private T getHelper(int index, Node N) {
        if (index == 0) {
            return N.item;
        }
        return getHelper(index - 1, N.next);
    }
    public T getRecursive(int index) {
        if (size <= index) {
            return null;
        } else {
            return getHelper(index, sentinel.next);
        }
    }


}
