package collections.org;

public class CustomLinkedList<E> implements List<E> {

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

    @Override
    public void add(int index, E element) {
        rangeCheck(index);

        Node<E> oldNode = getNode(index);
        Node<E> newNode = new Node<>(oldNode.prev, element, oldNode);
        oldNode.prev = newNode;

        size++;
    }

    @Override
    public boolean remove(Object o) {
        for (Node<E> n = first; n != null; n = n.next) {
            if(((E)o).equals(n.element)) {
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

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        Node<E> n = getNode(index);
        n.element = element;

        return n.element;
    }

    private Node<E> getNode(int index) {
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

    @Override
    public E get(int index) {
        rangeCheck(index);

        return getNode(index).element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {

    }

    private void rangeCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

}
