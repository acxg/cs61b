import java.util.Objects;

public class ArrayDeque<T>{
    private T[] array;
    private int size;
    private int nextfirst = 4, nextlast = 5;
    private int maxsize;
    private int RFACTOR = 2;

    public ArrayDeque(){
        maxsize = 8;
        array = (T [])new Object[maxsize];
        size = 0;
    }

    public void addFirst(T item){
        if(nextfirst == nextlast){
            resize(maxsize*RFACTOR);
        }
        array[nextfirst] = item;
        size += 1;
        if (nextfirst == 0){
            nextfirst = maxsize-1;
        }
        else{
            nextfirst -= 1;
        }
    }

    public void addLast(T item){
        if(nextfirst == nextlast){
            resize(maxsize*RFACTOR);
        }
        array[nextlast] = item;
        size += 1;
        if (nextlast == maxsize-1){
            nextfirst = 0;
        }
        else{
            nextlast += 1;
        }
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
        int last = nextlast;
        if(nextlast<nextfirst){
            last = maxsize+last;
        }
        for(int cnt = nextfirst+1; cnt < last; cnt++){
            System.out.print(array[cnt%maxsize].toString()+ ' ');
        }
        System.out.println();
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        T rem;
        int pos = (nextfirst+1)%maxsize;
        rem = array[pos];
        array[pos] = null;
        nextfirst = pos;
        size -= 1;
        return rem;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        T rem;
        int pos = (nextlast-1+maxsize)%maxsize;
        rem = array[pos];
        array[pos] = null;
        nextlast = pos;
        size -= 1;
        return rem;
    }

    public T get(int index){
        if(size <= index){
            return null;
        }
        int pos = ((nextfirst+1)%maxsize+index)%maxsize;
        return array[pos];
    }

    private void resize(int capacity){
        T[] a = (T[])new Object[capacity];
        System.arraycopy(array, 0,a,0,nextfirst);
        System.arraycopy(array,nextfirst+1,a,(capacity-(maxsize-nextfirst-1)),(maxsize-nextfirst-1));
        if(nextfirst!=0){
            nextfirst = capacity-(maxsize-1-nextfirst)-1;
        }
        maxsize = capacity;

    }
}
