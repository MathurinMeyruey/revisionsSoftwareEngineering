package src.container.container;

import java.util.Iterator;

public class IntPriorityQueue implements Queue<Integer> {
    public int capacity;
    public int[] queue;
    public int size;

    public IntPriorityQueue(Integer capacity){
        this.capacity=capacity;
        this.size=0;
        this.queue= new int[capacity];
    }
    @Override
    public boolean insertElement(Integer integer) {
        if (size==0){
            queue[size]=integer;
        }else if (size<capacity){
            queue[size]=integer;
            int index = size;
            int pere;
            if (index%2==0){pere= (index/2)-1;}else{pere=index/2;}
            int tampon;
            while (queue[index]>queue[pere]){
                tampon=queue[pere];
                queue[pere]=queue[index];
                queue[index]=tampon;
            }
        } else {
            int[] tab = new int[capacity + 10];
            System.arraycopy(queue, 0, tab, 0, capacity);
            queue=tab;
            queue[size]=integer;
            int index = size;
            int pere;
            if (index%2==0){pere= (index/2)-1;}else{pere=index/2;}
            int tampon;
            while (queue[index]>queue[pere]){
                tampon=queue[pere];
                queue[pere]=queue[index];
                queue[index]=tampon;
            }
            capacity+=10;
        }
        size++;
        return true;
    }

    @Override
    public Integer element() {
        return queue[0];
    }

    @Override
    public Integer popElement() {
        int element = queue[0];
        queue[0]=queue[size-1];
        queue[size-1]=element;
        int index=0;
        int fils;
        int tampon;
        if(queue[index]<queue[1]){fils=1;}else{fils=2;}
        while(queue[index]<queue[fils] && fils<size-1){
            tampon= queue[fils];
            queue[fils]=queue[index];
            queue[index]=tampon;
            index=fils;
            if (queue[index]<queue[index*2+1]){fils=index*2+1;}else{fils=index*2+2;}
        }
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
