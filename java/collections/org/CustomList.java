package collections.org;

/**
 * An ordered collection, where the user has precise control over where in the
 * list each element is inserted.
 *
 * @param <E> the type of elements in this list
 * @author  Alex
 */
public interface CustomList<E> {

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    boolean add(E element);

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index – index at which the specified element is to be inserted
     * @param element – element to be inserted
     * @throws IndexOutOfBoundsException – if the index is out of range
     */
    void add(int index, E element);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If the list does not contain the element, it is unchanged.
     *
     * @param o – o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    boolean remove(Object o);

    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     *
     * @param index – index of the element to replace
     * @param element – element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException – if the index is out of range
     */
    E set(int index, E element);

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    void clear();

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index – index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException – if the index is out of range
     */
    E get(int index);

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Sorts this list according to the order.
     */
    void sort();

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    boolean isEmpty();
}
