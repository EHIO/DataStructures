package sort;

import org.junit.Before;
import org.junit.Test;

public class SortAlgorithmTest {

    SortAlgorithm sortAlgorithm;

    @Before
    public void before() {
        sortAlgorithm = new SortAlgorithm();
    }

    /**
     * 快速排序之挖坑法
     */
    @Test
    public void testQuickSort() {
        int arr[] = {30, 40, 60, 10, 20, 50};
        SortAlgorithm.print(arr);
        SortAlgorithm.quickSort(arr, 0, arr.length - 1);
        SortAlgorithm.print(arr);
    }

    /**
     * 快速排序之左右指针法
     */
    @Test
    public void testQuickSort2() {
        int arr[] = {30, 40, 60, 10, 20, 50};
        SortAlgorithm.print(arr);
        SortAlgorithm.quickSort2(arr, 1, arr.length);
        SortAlgorithm.print(arr);
    }
}
