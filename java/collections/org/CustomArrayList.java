package collections.org;

import java.util.Arrays;

public class CustomArrayList<E> implements List<E> {

    private Object[] data;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public CustomArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean add(E element) {
        if(size == data.length) {
          data = grow();
        }

        data[size] = element;
        size += 1;

        return true;
    }

    private Object[] grow() {
        int newCapacity = data.length * 2;

        return data = Arrays.copyOf(data, newCapacity);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
