package src.container.container;

import java.util.Iterator;

public class IntFIFO implements Queue<Integer> {
    private int capacity;
    private int[] queue;
    private int start;
    private int size;
    public IntFIFO(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.start = 0;
        this.size = 0;
    }
    @Override
    public boolean insertElement(Integer integer) {
        if (size<capacity) {
            queue[(start + size) % capacity] = integer;
        } else {
            int[] tab= new int[capacity+10];
            if (capacity >= 0) System.arraycopy(queue, 0, tab, 0, capacity);
            queue=tab;
            queue[start+size]=integer;
            capacity+=10;
        }
        size++;
        return true;
    }

    @Override
    public Integer element() {
        return queue[start];
    }

    @Override
    public Integer popElement() {
        start++;
        size--;
        return queue[start-1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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