package linearlist_线性表;

/**
 * 单链表
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * @author Run
 */
public class SinglyLinkedList {

    public Node head;

    public SinglyLinkedList() {
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public void insertToHead(int value) {
        Node node = new Node(value, null);
        insertToHead(node);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node node = new Node(value, null);
        insertAfter(p, node);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        insertBefore(p, createNode(value));
    }

    /**
     * @param p
     * @param newNode
     */
    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (p == head) {
            insertToHead(p);
            return;
        }
        // 从头开始遍历
        Node q = head;
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

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }
        // 如果刚好是头结点
        if (p == head) {
            head = head.next;
        }
        // 从头开始遍历
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        // 没有找到
        if (q == null) {
            return;
        }
        q.next = q.next.next;
    }

    public void deleteByNode(int value) {
        if (head == null) {
            return;
        }
        // 从头开始遍历
        Node q = head;
        // 记录上一结点
        Node p = null;
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

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

    public Node findByValue(int value) {
        Node p = head;
        // 从头开始遍历
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    /**
     * 反转列表, 遍历法
     */
    public static Node reverse(Node node) {
        Node headNode = null;
        Node prevNode = null;
        Node currentNode = node;
        while (currentNode != null) {
            // 记录下一结点
            Node nextNode = currentNode.next;
            // 下个结点为null, 证明当前结点就是最后结点， 让它成为头结点
            if (nextNode == null) {
                headNode = currentNode;
            }
            // 反转指针， 指向前结点
            currentNode.next = prevNode;
            /*
             * 前结点， 当前结点后移
             */
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }


    public static void main(String[] args) {
        SinglyLinkedList slk = new SinglyLinkedList();
        Node node = createNode(1);
//        slk.insertToHead(node);
        slk.insertBefore(node, 2);
//        slk.insertBefore(createNode(3), 3);
//        slk.printAll();
        System.out.println();
    }
}
