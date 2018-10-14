package sort;

/**
 * 排序算法
 *
 * @author Run
 */
public class SortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5, 6};
        print(arr);
        insertionSort(arr);
        print(arr);
    }

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public static void bubbleSort(int[] arr) {
        // 外层循环控制排序趟数
        for (int i = 1; i < arr.length; i++) {
            System.out.println("第" + i + "趟排序");
            int count = 0;
            // 内层循环控制每一趟排序多少次
            for (int j = arr.length - 1; j >= i; j--) {
                ++count;
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
            System.out.println("比较次数：" + count);
            System.out.println();
        }
    }

    /**
     * 冒泡排序改进版
     *
     * @param arr
     * @return
     */
    public static void bubbleSort2(int[] arr) {
        // 外层循环控制排序趟数
        for (int i = 1; i < arr.length; i++) {
            System.out.println("第" + i + "趟排序");
            int count = 0;
            boolean flag = true;
            // 内层循环控制每一趟排序多少次
            for (int j = arr.length - 1; j >= i; j--) {
                ++count;
                // 有元素进行交换， flag转为false
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    flag = false;
                }
            }
            System.out.println("比较次数：" + count);
            System.out.println();
            // 一趟比较完后， 没有元素交换， 说明元素都是有序的
            if (flag) {
                break;
            }
        }
    }

    /**
     * 简单选择排序
     * @param arr
     * @return
     */
    public static void selectSort(int[] arr) {
        // 排序的趟数
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("第" + (i + 1) + "趟排序");
            // min用于记录每次最小的元素的下标
            int min = i;
            // 比较的次数， 从最后一个元素开始
            for (int j = arr.length - 1; j > i; j--) {
                // 找到需要交换的元素，记录最小元素的下标
                if (arr[j] < arr[min]) {
                    min = j;
                    System.out.println("需要交换元素的索引:" + min);
                }
            }
            // 每趟比较完后找到了最小元素的下标， 进行元素交换
            if (min != i) {
                swap(arr, min, i);
            }
        }
    }


    /**
     * 直接排入排序
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            /*int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j - 1, j);
                j--;
            }*/
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
