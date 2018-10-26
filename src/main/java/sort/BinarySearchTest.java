package sort;

import org.junit.Test;

/**
 * 二分查找
 */
public class BinarySearchTest {

    @Test
    public void testBsearch2() {
        int[] arr = {0, 2, 3, 4, 5, 8, 9};
        int index = BinarySearch.bsearch2(arr, 5);
        System.out.println(index);
    }

    @Test
    public void testBsearchVariant() {
        int[] arr = {0, 2, 3, 4, 5, 7, 8, 8, 8, 9};
        int index = BinarySearch.bsearchVariant(arr, 8);
        System.out.println(index);
    }

    @Test
    public void testBsearchVariant1() {
        int[] arr = {0, 2, 3, 4, 5, 7, 8, 8, 8, 9};
        int index = BinarySearch.bsearchVariant1(arr, 8);
        System.out.println(index);
    }

    @Test
    public void testBsearchVariant2() {
        int[] arr = {0, 2, 3, 4, 5, 7, 8, 8, 8, 9};
        int index = BinarySearch.bsearchVariant2(arr, 8);
        System.out.println(index);
    }

    @Test
    public void testBsearchVariant3() {
        int[] arr = {0, 2, 3, 4, 5, 7, 8, 9};
        int index = BinarySearch.bsearchVariant3(arr, 6);
        System.out.println("元素：" + arr[index]);
    }

    @Test
    public void testBsearchVariant4() {
        int[] arr = {0, 2, 3, 4, 5, 7, 8, 9};
        int index = BinarySearch.bsearchVariant4(arr, 6);
        System.out.println("元素：" + arr[index]);
    }
}
