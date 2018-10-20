package linearlist_线性表.linkedlist;

/**
 * 单链表
 * 单链表的插入、删除、查找操作；
 *
 * @author Run
 */
public class SinglyLinkedList<E> {

    public Node<E> head;

    public SinglyLinkedList() {
    }

    public Node<E> createNode(E value) {
        return new Node<>(value, null);
    }

    public void insertToHead(E value) {
        insertToHead(createNode(value));
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 插入指定结点的后面
     *
     * @param p
     * @param value
     */
    public void insertAfter(Node<E> p, E value) {
        insertAfter(p, createNode(value));
    }

    /**
     * 插入指定结点的后面
     *
     * @param p
     * @param newNode
     */
    private void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 插入指定结点的前面
     *
     * @param p
     * @param value
     */
    public void insertBefore(Node p, E value) {
        insertBefore(p, createNode(value));
    }

    /**
     * @param p
     * @param newNode
     */
    public void insertBefore(Node<E> p, Node<E> newNode) {
        if (p == null) {
            return;
        }
        if (p == head) {
            insertToHead(newNode);
            return;
        }
        // 从头开始遍历
        Node<E> q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        // 没有找到指定结点p
        if (q == null) {
            return;
        }
        q.next = newNode;
        newNode.next = p;
    }

    public void deleteByNode(Node<E> p) {
        if (p == null || head == null) {
            return;
        }
        // 如果刚好是头结点
        if (p == head) {
            head = head.next;
        }
        // 从头开始遍历
        Node<E> q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        // 没有找到
        if (q == null) {
            return;
        }
        q.next = q.next.next;
    }

    public void deleteByNode(E value) {
        if (head == null) {
            return;
        }
        // 从头开始遍历
        Node<E> q = head;
        // 记录上一结点
        Node<E> p = null;
        while (q != null && q.data != value) {
            p = q;
            q = q.next;
        }
        // 如果没有找到
        if (q == null) {
            return;
        }
        // 头结点值满足
        if (p == null) {
            head = head.next;
        } else {
            p.next = q.next.next;
        }
    }

    public Node<E> findByValue(E value) {
        Node p = head;
        // 从头开始遍历
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node<E> findByIndex(int index) {
        Node<E> p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    public static void print(Node node) {
        if (node != null) {
            System.out.println(node.data + " ");
        }
    }

    public void printAll() {
        Node<E> p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }
    }
}
