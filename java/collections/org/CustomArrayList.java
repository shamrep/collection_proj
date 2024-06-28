package collections.org;

public class CustomArrayList<E extends Comparable> implements List<E> {

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
            data[i + 1] = data[i];
        }

        data[index + 1] = element;
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

        System.arraycopy(original, 0, newArray, 0, original.length);
//        System.arraycopy(original, 0, newArray, 0, original.length);
        return newArray;
    }

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

    @Override
    public E set(int index, E element) {
//        Objects.checkIndex(index, size);
        rangeCheckForAdd(index);
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
//        Objects.checkIndex(index, size);
        rangeCheckForAdd(index);

        return (E) data[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {
        quickSort(data, 0, size - 1);
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
            if (((E) arr[j]).compareTo(pivot) < 0) {
                i++;
                Object temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Object temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
