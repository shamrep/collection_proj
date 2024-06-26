package collections.org;

public interface List<E> {
    boolean add(E element);
    boolean remove(Object o);
    E set(int index, E element);
    void clear();
    E get(int index);
}
