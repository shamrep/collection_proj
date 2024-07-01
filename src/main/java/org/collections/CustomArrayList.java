package org.collections;

import java.util.Collection;

/**
 * Resizable-array implementation of the {@code CustomList} interface.
 *
 * @param <E> the type of elements in this list
 * @author Alex
 */
public class CustomArrayList<E extends Comparable> implements CustomList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public CustomArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public CustomArrayList(Collection<? extends E> c) {
        this.data = new Object[c.size()];

        for(Object o : c) {
            add((E) o);
        }
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(E element) {
        if (size == data.length) {
            data = grow();
        }

        data[size] = element;
        size += 1;

        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index   – index at which the specified element is to be inserted
     * @param element – element to be inserted
     * @throws IndexOutOfBoundsException – if the index is out of range
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == size) {
            add(element);
        } else {
            if (size == data.length) {
                data = grow();
            }

            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }

            data[index] = element;
            size += 1;
        }
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

        return data = copyOf(data, newCapacity);
    }

    private Object[] copyOf(Object[] original, int capacity) {
        Object[] newArray = new Object[capacity];

        System.arraycopy(original, 0, newArray, 0, original.length);

        return newArray;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If the list does not contain the element, it is unchanged.
     *
     * @param o – o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i <= size - 1; i++) {

            if (data[i].equals(o)) {
                if (i == size - 1) {
                    data[i] = null;
                    size -= 1;
                    return true;
                }

                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }

                size -= 1;
                data[size] = null;

                return true;
            }
        }

        return false;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     *
     * @param index   – index of the element to replace
     * @param element – element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException – if the index is out of range
     */
    @Override
    public E set(int index, E element) {
        rangeCheckForAdd(index);

        E oldValue = (E) data[index];
        data[index] = element;

        return oldValue;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index – index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException – if the index is out of range
     */
    @Override
    public E get(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        rangeCheckForAdd(index);

        return (E) data[index];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Sorts this list according to the order.
     */
    @Override
    public void sort() {
        quickSort(data, 0, size - 1);
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void quickSort(Object[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Object[] arr, int low, int high) {
        Object pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if(arr[j] == null) {
                i++;
                Object temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                if (((E) arr[j]).compareTo(pivot) < 0) {
                    i++;
                    Object temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        Object temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
