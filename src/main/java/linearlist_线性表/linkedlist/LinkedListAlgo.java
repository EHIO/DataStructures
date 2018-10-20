package linearlist_线性表.linkedlist;

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
             * 前结点， 当前结点后移
             */
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }

    private static class Node<E> {
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
