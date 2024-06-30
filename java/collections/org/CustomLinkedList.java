package collections.org;

/**
 * Doubly-linked list implementation of the {@code CustomList} and {@code Deque}
 * interfaces.
 *
 * @param <E> the type of elements held in this collection
 * @author Alex
 */
public class CustomLinkedList<E extends Comparable> implements CustomList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    private class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element - element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, element, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }

        size++;

        return true;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(int index, E element) {
        rangeCheck(index);

        Node<E> oldNode = getNode(index);
        Node<E> newNode = new Node<>(oldNode.prev, element, oldNode);
        oldNode.prev = newNode;

        size++;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param o – element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        for (Node<E> n = first; n != null; n = n.next) {
            if (o.equals(n.element)) {
                Node<E> next = n.next;
                Node<E> prev = n.prev;

                next.prev = n.prev;
                prev.next = n.next;

                clearNode(n);

                size--;

                return true;
            }
        }

        return false;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     *
     * @param index – index of the element to replace
     * @param element – element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException – if the index is out of range
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        Node<E> n = getNode(index);
        E oldElement = n.element;
        n.element = element;

        return oldElement;
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);

        Node<E> n;

        if (size < index / 2) {
            n = first;
            for (int i = 1; i <= index; i++) {
                n = n.next;
            }
        } else {
            n = last;
            for (int i = size - 1; i > index; i--) {
                n = n.prev;
            }
        }

        return n;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        for (Node<E> n = first; n != null; ) {
            Node<E> next = n.next;
            clearNode(n);
            n = next;
        }

        first = last = null;
        size = 0;
    }

    private void clearNode(Node<E> n) {
        n.element = null;
        n.next = null;
        n.prev = null;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) {
        rangeCheck(index);

        return getNode(index).element;
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
        if (size > 1) {
            first = mergeSort(first);

            // Fix the last reference after sorting
            last = first;
            while (last.next != null) {
                last = last.next;
            }
        }
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

    private Node<E> mergeSort(Node<E> head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        Node<E> middle = getMiddle(head);
        Node<E> nextOfMiddle = middle.next;

        middle.next = null;
        if (nextOfMiddle != null) {
            nextOfMiddle.prev = null;
        }

        // Recursively sort the two halves
        Node<E> left = mergeSort(head);
        Node<E> right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        return sortedMerge(left, right);
    }

    private Node<E> getMiddle(Node<E> head) {
        if (head == null) {
            return head;
        }

        Node<E> slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper method to merge two sorted linked lists
    private Node<E> sortedMerge(Node<E> left, Node<E> right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node<E> result;
        if (left.element.compareTo(right.element) <= 0) {
            result = left;
            result.next = sortedMerge(left.next, right);
            if (result.next != null) {
                result.next.prev = result;
            }
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
            if (result.next != null) {
                result.next.prev = result;
            }
        }
        return result;
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

}
