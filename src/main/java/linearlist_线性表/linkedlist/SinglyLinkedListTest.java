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
        slk.insertToHead(1);
        slk.insertToHead(2);
        slk.printAll();

        SinglyLinkedList.print(slk.findByIndex(0));
    }

    @Test
    public void testFindByValue() {
        slk.insertToHead(1);
        slk.insertToHead(2);
        slk.printAll();

        SinglyLinkedList.print(slk.findByValue(1));
    }

    @Test
    public void testInsertBefore() {
        slk.insertToHead(1);
        slk.insertToHead(2);
        slk.printAll();

        slk.insertBefore(slk.findByIndex(1),3);
        slk.printAll();
    }

    @Test
    public void testInsertAfter() {
        slk.insertToHead(1);
        slk.insertToHead("a");
        slk.printAll();

        slk.insertAfter(slk.findByIndex(1),3);
        slk.printAll();
    }
}
