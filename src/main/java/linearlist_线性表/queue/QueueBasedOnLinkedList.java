package linearlist_线性表.queue;

/**
 * 基于链表实现的队列
 *
 * @author Run
 */
public class QueueBasedOnLinkedList<E> {

    /**
     * 队头
     */
    private Node<E> head;

    /**
     * 队尾
     */
    private Node<E> tail;

    /**
     * 入队
     * @param data
     */
    public void  enqueue(E data) {
        Node<E> newNode = new Node<>(data, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    /**
     * 出队
     */
    public E dequeue() {
        if (head == null) {
            return null;
        }
        E value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    private static class Node<E> {
        private Node<E> next;

        private E data;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }
    }


    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();

    }





}
