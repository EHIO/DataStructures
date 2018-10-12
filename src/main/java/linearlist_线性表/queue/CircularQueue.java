package linearlist_线性表.queue;

/**
 * 循环队列
 *
 * @author Run
 */
public class CircularQueue<T> {

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

    public CircularQueue(int capacity) {
        items = newArray(capacity);
        this.capacity = capacity;
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int size) {
        return (T[]) new Object[size];
    }

    /**
     * 入队
     * @param ele
     * @return
     */
    public boolean enqueue(T ele) {
        // 队列已满， 返回
        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = ele;
        tail = (tail + 1) % capacity;
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
        head = (head + 1) % capacity;
        return ele;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        // 出队
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        queue.printAll();
    }
}
