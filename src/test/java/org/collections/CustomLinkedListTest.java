package org.collections;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class CustomLinkedListTest {
    @Test
    public void sort_unsortedList_sortedList() {
        // given
        CustomLinkedList<Integer> list = new CustomLinkedList<>(asList(5, 1, 2, 0));

        // when
        list.sort();

        // then
        assertEqualsList(asList(0, 1, 2, 5), list);
    }

    @Test
    public void sort_thereAreNulls_nullsFirst() {
        // given
        CustomLinkedList<Integer> list = new CustomLinkedList<>(asList(5, 1, null, 2, 0));

        // when
        list.sort();

        // then
        assertEqualsList(asList(null, 0, 1, 2, 5), list);
    }

    private void assertEqualsList(List<Integer> expectedList, CustomLinkedList<Integer> actualList) {
        assertEquals(expectedList.size(), actualList.size());

        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }
    }

    @Test
    public void add_checkAdd_correctOrder() {
        // given
        CustomArrayList<Integer> list = new CustomArrayList<>();

        // when
        list.add(1);
        list.add(3);
        list.add(0);
        int size = list.size();

        // then
        assertEquals(3, size);
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(0), list.get(2));
    }

    @Test
    public void add_checkAddByIndex_changedElement() {
        // given
        CustomArrayList<Integer> list = new CustomArrayList<>();

        // when
        list.add(0, 1);
        list.add(1, 2);
        list.add(1, 3);

        // then
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
    }

    @Test
    public void clear_deleteAllElements_emptyList() {
        // given
        CustomArrayList<Integer> list = new CustomArrayList<>(asList(1, 2, 3));

        // when
        list.clear();

        // then
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void set_changeElementValueByIndex_changedValue() {
        // given
        CustomArrayList<Integer> list = new CustomArrayList<>(asList(1, 2, 3));

        // when
        list.set(1, 4);

        // then
        assertEquals(Integer.valueOf(4), list.get(1));
    }

    @Test
    public void get_getElementValue_elementValue() {
        // given
        CustomArrayList<Integer> list = new CustomArrayList<>(asList(1, 2, 3));

        // when
        Integer value = list.get(1);

        // then
        assertEquals(Integer.valueOf(2), value);
    }

    @Test
    public void size() {
        // given
        CustomArrayList<Integer> list = new CustomArrayList<>();

        assertEquals(0, list.size());

        // when
        list.add(1);

        // then
        assertEquals(1, list.size());
    }

    @Test
    public void isEmpty_checkSize_ZeroSize() {
        // given
        CustomArrayList<Integer> list = new CustomArrayList<>();

        // then
        assertEquals(0, list.size());

        // when
        list.add(1);

        // then
        assertNotEquals(0, list.size());

        // when
        list.remove(1);

        // then
        assertEquals(0, list.size());
    }
//    private CustomLinkedList<Integer> list;
//
//    @Before
//    public void setUp() {
//        list = new CustomLinkedList<>();
//    }
//
//    @Test
//    public void add() {
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        assertEquals(3, list.size());
//
//        assertEquals(Integer.valueOf(1), list.get(0));
//        assertEquals(Integer.valueOf(2), list.get(1));
//        assertEquals(Integer.valueOf(3), list.get(2));
//    }
//
//    @Test
//    public void indexAdd() {
//        list.add(0, 1);
//        list.add(1, 2);
//        list.add(1, 3);
//
//        assertEquals(3, list.size());
//        assertEquals(Integer.valueOf(1), list.get(0));
//        assertEquals(Integer.valueOf(3), list.get(1));
//        assertEquals(Integer.valueOf(2), list.get(2));
//    }
//
//    @Test
//    public void remove() {
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.clear();
//        assertEquals(0, list.size());
//        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
//    }
//
//    @Test
//    public void set() {
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.set(1, 4);
//        assertEquals(Integer.valueOf(4), list.get(1));
//    }
//
//    @Test
//    public void clear() {
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.clear();
//        assertEquals(0, list.size());
//        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
//    }
//
//    @Test
//    public void get() {
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        assertEquals(Integer.valueOf(2), list.get(1));
//    }
//
//    @Test
//    public void size() {
//        assertEquals(0, list.size());
//        list.add(1);
//        assertEquals(1, list.size());
//    }
//
//    @Test
//    public void sort() {
//        list.add(5);
//        list.add(1);
//        list.add(2);
//        list.add(0);
//        list.add(null);
//
//        list.sort();
//
//        assertEquals(null, list.get(0));
//        assertEquals(Integer.valueOf(0), list.get(1));
////        assertEquals(Integer.valueOf(2), list.get(2));
////        assertEquals(Integer.valueOf(5), list.get(3));
//    }
//
//    @Test
//    public void isEmpty() {
//        assertEquals(0, list.size());
//        list.add(1);
//        assertNotEquals(0, list.size());
//    }
}