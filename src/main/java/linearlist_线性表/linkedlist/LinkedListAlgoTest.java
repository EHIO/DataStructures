package linearlist_线性表.linkedlist;

import org.junit.Before;
import org.junit.Test;


public class LinkedListAlgoTest<E> {

    LinkedListAlgo link;

    @Before
    public void before() {

    }

    @Test
    public void testReverse() {
        LinkedListAlgo.Node node = LinkedListAlgo.readyNode();
        LinkedListAlgo.printAll(node);

        node = LinkedListAlgo.reverse(node);
        LinkedListAlgo.printAll(node);
    }
}
