package linearlist_线性表.linkedlist;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DoubleLinkedListTest {

    DoubleLinkedList link;

    @Before
    public void before() {
        link = new DoubleLinkedList();
    }

    public DoubleLinkedList prepareData() {
        link.add(1);
        link.add(2);
        return link;
    }

    @Test
    public void testAdd() {
        link = prepareData();
        link.add(1, "a");
        link.printAll();
    }

    @Test
    public void testAddFirst() {
        link.addFirst(1);
        link.addFirst("a");
        link.printAll();
    }

    @Test
    public void testAddLast() {
        link.addLast(1);
        link.addLast("a");
        link.printAll();
    }

    @Test
    public void testGet() {
        link = prepareData();
        Object ele = link.get(1);
        System.out.println(ele);
    }

    @Test
    public void testSet() {
        link = prepareData();
        link.printAll();
        Object ele = link.set(1, 'a');
        System.out.println(ele);
        link.printAll();
    }

}
