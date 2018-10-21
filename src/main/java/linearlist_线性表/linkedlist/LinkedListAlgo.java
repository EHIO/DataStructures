package linearlist_线性表.linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * @author Run
 */
public class LinkedListAlgo<E> {


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
             * 前结点， 当前结点指针后移
             */
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }

    public static void printAll(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node readyNode() {
        Node linkNode1 = new Node();
        linkNode1.data = 1;
        Node linkNode2 = new Node();
        linkNode2.data = 2;
        Node linkNode3 = new Node();
        linkNode3.data = 3;
        Node linkNode4 = new Node();
        linkNode4.data = 4;
        Node linkNode5 = new Node();
        linkNode5.data = 5;
        Node linkNode6 = new Node();
        linkNode6.data = 6;
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;
        return linkNode1;
    }

    public static class Node<E> {
        private E data;
        private Node<E> next;

        public Node() {

        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }
    }
}
