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

    /**
     * 二分查找变体一： 查找第一个值等于给定值的元素
     */
    public static int bsearchVariant(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (arr[low] == value) {
            return low;
        }
        return -1;
    }

    /**
     * 二分查找变体一： 查找第一个值等于给定值的元素
     * 通俗版
     */
    public static int bsearchVariant1(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                // 中间元素前一个元素不等于给定值， 说明是第1个值
                if (mid == 0 || arr[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变体二：查找最后一个值等于给定值的元素
     */
    public static int bsearchVariant2(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                // 中间元素前一个元素不等于给定值， 说明是第1个值
                if (mid == arr.length - 1 || arr[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变体三：查找第一个大于等于给定值的元素
     */
    public static int bsearchVariant3(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= value) {
                if (mid == 0 || arr[mid - 1] < value) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变体四：查找最后一个小于等于给定值的元素
     */
    public static int bsearchVariant4(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }
}
