package linearlist_线性表.stack;


/**
 * 基于数组实现的栈
 *
 * @author Run
 */
public class GeneralArrayStack<E> {

    private static final int DEFAULT_SIZE = 10;
    private E[] mArray;
    /**
     * 栈中元素的个数
     */
    private int count;

    public GeneralArrayStack() {
        this(DEFAULT_SIZE);
    }

    public GeneralArrayStack(int size) {

        mArray = (E[]) new Object[size];
        count = 0;
    }

    // 将val添加到栈中
    public void push(E val) {
        mArray[count++] = val;
    }

    // 返回“栈顶元素值”
    public E peek() {
        return mArray[count - 1];
    }

    // 返回“栈顶元素值”，并删除“栈顶元素”
    public E pop() {
        E ret = mArray[count - 1];
        count--;
        return ret;
    }

    // 返回“栈”的大小
    public int size() {
        return count;
    }

    // 返回“栈”是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 打印“栈”
    public void printArrayStack() {
        if (isEmpty()) {
            System.out.printf("stack is Empty\n");
        }

        System.out.printf("stack size()=%d\n", size());

        int i = size() - 1;
        while (i >= 0) {
            System.out.println(mArray[i]);
            i--;
        }
    }

    public static void main(String[] args) {
        GeneralArrayStack stack = new GeneralArrayStack();
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());

        System.out.println(stack.peek());
        stack.printArrayStack();
    }
}
