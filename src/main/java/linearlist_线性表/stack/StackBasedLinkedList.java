package linearlist_线性表.stack;

/**
 * 基于链表实现的栈
 *
 * @author Run
 */
public class StackBasedLinkedList<E> {

    private Node<E> top;

    /**
     * 入栈
     */
    public void push(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 出栈
     */
    public E pop() {
        if (top == null) {
            return null;
        }
        E value = top.data;
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node<E> {
        private E data;

        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        StackBasedLinkedList<Integer> stack = new StackBasedLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printAll();


        stack.pop();
        stack.pop();
        stack.printAll();
    }
}

