package sort;

/**
 * 二分查找
 */
public class BinarySearch {


    public static int bsearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + (high - low) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归法
     * @param arr
     * @param value
     * @return
     */
    public static int bsearch2(int[] arr, int value) {

        return bsearchInternally(arr, 0, arr.length - 1, value);
    }

    public static int bsearchInternally(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return bsearchInternally(arr, mid + 1, high, value);
        } else {
            return bsearchInternally(arr, low, mid - 1, value);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 5, 8, 9};
        int index = bsearch2(arr, 5);
        System.out.println(index);
    }
}
