package linearlist_线性表.linkedlist;

/**
 * 单链表
 * 单链表的插入、删除、查找操作；
 * 添加
 * 1、添加首、尾、指定索引处、指定索引结点前，后
 *
 * @author Run
 */
public class SinglyLinkedList<E> {

    /**
     * 头结点指针
     */
    public Node<E> head;

    /**
     * 尾结点指针
     */
    public Node<E> last;

    /**
     * 链表长度
     */
    public int size;

    public SinglyLinkedList() {
    }

    public Node<E> createNode(E value) {
        return new Node<>(value, null);
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void add(int index, E e) {
        // 校验索引
        if (index == size) {
            addLast(e);
        } else {
            insertAfter(index, e);
        }
    }

    /**
     * 添加到头
     *
     * @param e
     */
    public void addFirst(E e) {
        addFirst(createNode(e));
    }

    public void addFirst(Node<E> newNode) {
        final Node<E> f = head;
        // 头指针指向新结点
        head = newNode;
        if (f == null) {
            last = newNode;
        } else {
            newNode.next = f;
        }
        size++;
    }

    /**
     * 添加到尾
     *
     * @param e
     */
    public void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = createNode(e);
        last = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 插入指定结点的后面
     *
     * @param index
     * @param value
     */
    public void insertAfter(int index, E value) {
        insertAfter(findByIndex(index), createNode(value));
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
        size++;
    }

    /**
     * 插入指定结点的前面
     *
     * @param index
     * @param value
     */
    public void insertBefore(int index, E value) {
        insertBefore(findByIndex(index), createNode(value));
    }

    /**
     * 插入指定结点的前面
     *
     * @param p
     * @param newNode
     */
    public void insertBefore(Node<E> p, Node<E> newNode) {
        if (p == null) {
            return;
        }
        if (p == head) {
            addFirst(newNode);
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
