package collections.org;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomArrayListTest {

    CustomArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new CustomArrayList<>();
        list.add(9);
        list.add(6);
        list.add(7);
        list.add(1);
        list.add(3);
    }

    @Test
    public void add() {

    }

    @Test
    public void testAdd() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void set() {
    }

    @Test
    public void clear() {

    }

    @Test
    public void get() {
    }

    @Test
    public void size() {
        Assert.assertEquals(list.size(), 5);
    }

    @Test
    public void sort() {

        list.sort();

        CustomArrayList<Integer> actualList = new CustomArrayList<>();
        actualList.add(1);
        actualList.add(3);
        actualList.add(6);
        actualList.add(7);
        actualList.add(9);

        for (int i = 0; i < list.size() - 1; i++) {
            Assert.assertEquals(list.get(i), actualList.get(i));
        }
    }

    @Test
    public void isEmpty() {
    }
}