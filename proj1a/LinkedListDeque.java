public class LinkedListDeque<T>{
    private Node sentinel;
    private int size;
    private T a;

    private class Node{
        public T item;
        public Node prev;
        public Node next;

        public Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        Node NewNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = NewNode;
        sentinel.next = NewNode;
        size += 1;
    }

    public void addLast(T item){
        Node NewNode = new Node(item, sentinel.prev,sentinel);
        sentinel.prev.next = NewNode;
        sentinel.prev = NewNode;
        size += 1;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if(size == 0){
            return;
        }
        Node First = sentinel.next;
        for(int cnt = 1; cnt < size; cnt++){
            System.out.print(First.item.toString() + ' ');
            First = First.next;
        }
        System.out.print(First.item.toString());
        System.out.println();
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        T rem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return rem;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        T rem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return rem;
    }

    public T get(int index){
        if(size <= index){
            return null;
        }
        Node cur = sentinel.next;
        for(int cnt = 0; cnt < index; cnt++){
            cur = cur.next;
        }
        return cur.item;
    }

    private T getHelper(int index, Node N){
        if(index == 0){
            return N.item;
        }
        return getHelper(index-1, N.next);
    }
    public T getRecursive(int index){
        if(size <= index){
            return null;
        }
        else{
            return getHelper(index, sentinel.next);
        }
    }


}
