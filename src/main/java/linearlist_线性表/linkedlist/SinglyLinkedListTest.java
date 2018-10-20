package linearlist_线性表.linkedlist;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class SinglyLinkedListTest {

    SinglyLinkedList slk;

    @Before
    public void before() {
        slk = new SinglyLinkedList();
    }

    @Test
    public void testFindByIndex() {
        slk.add(1);
        slk.add(2);
        slk.printAll();

        SinglyLinkedList.print(slk.findByIndex(0));
    }

    @Test
    public void testFindByValue() {
        slk.add(1);
        slk.add(2);
        slk.printAll();

        SinglyLinkedList.print(slk.findByValue(1));
    }

    @Test
    public void testAdd() {
        slk.add(1);
        slk.add(2);
        slk.add(0, "a");
        slk.add(1, "b");
        slk.printAll();
    }

    @Test
    public void testAddFirst() {
        slk.addFirst(1);
        slk.addFirst(2);
        slk.printAll();
    }

    @Test
    public void testAddLast() {
        slk.addLast(1);
        slk.addLast(2);
        slk.printAll();
    }

    @Test
    public void testInsertBefore() {
        slk.add(1);
        slk.add(2);
        slk.printAll();

        slk.insertBefore(1, 3);
        slk.printAll();
    }

    @Test
    public void testInsertAfter() {
        slk.add(1);
        slk.add("a");
        slk.printAll();

        slk.insertAfter(1, 3);
        slk.printAll();
    }
}
