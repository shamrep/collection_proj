package collections.org;

import java.util.Objects;

public class CustomArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public CustomArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean add(E element) {
        if (size == data.length) {
            data = grow();
        }

        data[size] = element;
        size += 1;

        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (size == data.length) {
            data = grow();
        }

//        System.arraycopy(data, index, data, index + 1, size - index);

        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index+1] = element;
        size += 1;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private Object[] grow() {
        int newCapacity = data.length * 2;

//        return data = Arrays.copyOf(data, newCapacity);
        return data = copyOf(data, newCapacity);
    }

    private Object[] copyOf(Object[] original, int capacity) {
        Object[] newArray = new Object[capacity];

        for (int i = 0; i < original.length; i++) {
            newArray[i] = original[i];
        }
//        System.arraycopy(original, 0, newArray, 0, original.length);
        return newArray;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        data[index] = element;

        return (E) data[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        size = 0;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);

        return (E) data[index];
    }

    @Override
    public int size() {
        return size;
    }
}
