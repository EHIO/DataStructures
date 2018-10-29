package linearlist_线性表.skiplist;


import org.junit.Before;
import org.junit.Test;

public class SkipListTest {

    SkipList skipList;

    @Before
    public void before() {
        skipList = new SkipList();
    }


    @Test
    public void testInsert() {
        skipList.insert(3);
        skipList.printAll();
    }
}