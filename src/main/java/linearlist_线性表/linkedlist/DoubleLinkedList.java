package linearlist_线性表.linkedlist;

/**
 * 双链表实现
 *
 * @author Run
 */
public class DoubleLinkedList<E> {

    /**
     * 头结点
     */
    private Node<E> first;
    /**
     * 尾结点
     */
    private Node<E> last;

    /**
     *
     */
    private int size;

    /**
     * 列表结构被修改的次数
     */
    private int modCount;

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    /**
     * 添加到指定索引处
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size) {
            addLast(element);
        } else {
            addBefore(element, node(index));
        }
    }

    public void addFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        // 新结点变成头结点
        first = newNode;
        if (f == null) {
            // 头、尾结点指向同一结点
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
        modCount++;
    }


    public void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        // 尾结点指针指向新结点
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * 添加到指定结点前
     */
    public void addBefore(E e, Node<E> node) {
        final Node pred = node.prev;
        final Node<E> newNode = new Node<>(pred, e, node);
        // 指定结点的前指针指向新结点
        node.prev = newNode;
        // 指定结点前结点为空， 把头结点指向新结点
        if (pred == null) {
            first = newNode;
        } else {
            // 前结点的尾指针指向新结点
            pred.next = newNode;
        }
        size++;
        modCount++;
    }

    public void remove(int index) {
        remove(node(index));
    }

    public E remove(Node<E> x) {
        final E element = x.item;
        final Node prev = x.prev;
        final Node next = x.next;

        if (prev == null) {
            first = next;
        } else {
            // x的前结点的后指针指向x的后结点的前指针
            prev.next = next;
            // x的前指针置为null
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            // x的后结点的前指针指向x的前结点的后指针
            next.prev = prev;
            // x的后指针置为null
            x.next = null;
        }

        // 移除结点的值域置为null
        x.item = null;
        size--;
        modCount++;
        return element;
    }

    public Node<E> node(int index) {
        Node<E> node;
        // 从头开始搜索
        if (index < size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = first.next;
            }
        } else {
            // 从尾开始搜索
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public E set(int index, E newVal) {
        checkElementIndex(index);
        Node<E> node = node(index);
        E oldVal = node.item;
        node.item = newVal;
        return oldVal;
    }

    public void printAll() {
        Node p = first;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 元素索引判断
     * @param index
     * @return
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * 位置索引判断
     * @param index
     * @return
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private static class Node<E> {
        private Node<E> prev;

        private Node<E> next;

        private E item;

        public Node(Node prev, E item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        DoubleLinkedList link = new DoubleLinkedList();
//        link.add(1);
//        link.add(2);
//        link.addFirst(3);
        link.add(0, 1);
        link.add(1, 2);
        link.remove(1);

        System.out.println(link);
    }
}
