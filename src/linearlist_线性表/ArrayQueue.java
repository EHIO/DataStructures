package linearlist_线性表;

/**
 * 数组实现队列
 *
 * @author Run
 */
public class ArrayQueue<T> {

    private T[] items;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 队头下标
     */
    private int head;
    /**
     * 队尾下标
     */
    private int tail;

    public ArrayQueue(int capacity) {
        items = newArray(capacity);
        this.capacity = capacity;
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int size) {
        return (T[]) new Object[size];
    }

    /**
     * 入队
     *
     * @param ele
     * @return
     */
    public boolean enqueue(T ele) {
        // 队列已满
        if (tail == capacity) {
            return false;
        }
        items[tail] = ele;
        tail++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public T dequeue() {
        if (head == tail) {
            return null;
        }
        T ele = items[head];
        head++;
        return ele;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);
    }
}
