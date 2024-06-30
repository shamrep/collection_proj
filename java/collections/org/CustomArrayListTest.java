package collections.org;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomArrayListTest {

    private CustomArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new CustomArrayList<>();
    }

    @Test
    public void add() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());

        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testAdd() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(1, 3);

        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
    }

    @Test
    public void remove() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void set() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.set(1, 4);
        assertEquals(Integer.valueOf(4), list.get(1));
    }

    @Test
    public void clear() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void get() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(2), list.get(1));
    }

    @Test
    public void size() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    public void sort() {
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(0);

        list.sort();

        assertEquals(Integer.valueOf(0), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
        assertEquals(Integer.valueOf(5), list.get(3));
    }

    @Test
    public void isEmpty() {
        assertEquals(0, list.size());
        list.add(1);
        assertNotEquals(0, list.size());
    }
}