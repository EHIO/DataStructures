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
     * 冒泡排序
     */
    @Test
    public void testBubbleSort() {
        int[] arr = {4, 5, 6, 3, 2, 1};
        SortAlgorithm.print(arr);
        SortAlgorithm.bubbleSort(arr);
        SortAlgorithm.print(arr);
    }

    /**
     * 插入排序
     */
    @Test
    public void testInsertionSort() {
        int[] arr = {2, 1, 3, 4, 5, 6};
        SortAlgorithm.print(arr);
        SortAlgorithm.insertionSort(arr);
        SortAlgorithm.print(arr);
    }

    /**
     * 选择排序
     */
    @Test
    public void testSelectSort() {
        int[] arr = {4, 5, 6, 3, 2, 1};
        SortAlgorithm.print(arr);
        SortAlgorithm.selectSort(arr);
        SortAlgorithm.print(arr);
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
