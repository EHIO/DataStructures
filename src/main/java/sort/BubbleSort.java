package sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5, 6};
        print(arr);
        arr = bubbleSort(arr);
        print(arr);


    }

    public static int[] bubbleSort(int[] arr) {
        // 外层循环控制排序趟数
        for (int i = 1; i < arr.length; i++) {
            int count = 0;
            System.out.println("每一趟排序：" + i);
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
        return arr;
    }

    /**
     * 改进版
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort2(int[] arr) {
        boolean flag = true;
        // 外层循环控制排序趟数
        for (int i = 1; i < arr.length && flag; i++) {
            flag = false;
            int count = 0;
            System.out.println("每一趟排序：" + i);
            // 内层循环控制每一趟排序多少次
            for (int j = arr.length - 1; j >= i; j--) {
                ++count;
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    flag = true;
                }
            }
            System.out.println("比较次数：" + count);
            System.out.println();
        }
        return arr;
    }

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }


    public static void print(int[] arr) {
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

}
