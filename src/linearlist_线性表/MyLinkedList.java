package linearlist_线性表;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 双链表实现
 */
public class MyLinkedList<E> implements Iterable<E> {

    private int theSixe;

    /**
     * 列表结构被修改的次数
     */
    private int modCount;

    /**
     * 头结点
     */
    private Node<E> beginMarker;
    /**
     * 尾结点
     */
    private Node<E> endMarker;


    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<E>(null, null, null);
        endMarker = new Node<E>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSixe = 0;
        modCount++;
    }

    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    public void add(int idx, E e) {
        addBefore(getNode(idx, 0, size()), e);
    }

    public E get(int idx) {
        return getNode(idx).data;
    }

    public E set(int idx, E newVal) {
        Node<E> p = getNode(idx);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public E remove(int idx) {
        return remove(getNode(idx));
    }

    public E remove(Node<E> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSixe--;
        modCount++;
        return p.data;
    }

    private void addBefore(Node<E> p, E e) {
        Node<E> newNode = new Node<E>(e, p.prev, p);
        // 前结点引用指向新结点
        newNode.prev.next = newNode;
        // 当前结点p的前结点引用指向新结点
        p.prev = newNode;
        theSixe++;
        modCount++;
    }

    private Node<E> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<E> getNode(int idx, int lower, int upper) {
        Node<E> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        // 索引处于前半部分
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return theSixe;
    }

    private static class Node<E> {
        public E data;

        public Node prev;

        public Node next;

        public Node(E e, Node<E> p, Node<E> n) {
            data = e;
            prev = p;
            next = n;
        }
    }

    public static void print(Node node) {
        if (node != null) {
            System.out.println(node.data);
        }
    }

    public void printAll() {
        Node p = beginMarker;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListInerator();
    }

    private class LinkedListInerator implements Iterator<E> {
        private Node<E> current = beginMarker.next;

        private int expectedModcount = modCount;

        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public E next() {
            if (modCount != expectedModcount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E nextItem = current.data;
            // 移动至下一结点
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModcount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            expectedModcount++;
            okToRemove = false;
        }
    }


    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.add(1);
        mll.add(2);
        mll.set(1, 3);
//        mll.remove(0);
//        Node node = mll.getNode(1);
//        Node node2 = mll.getNode(0);
//        MyLinkedList.print(node);
//        MyLinkedList.print(node2);

        Iterator iterator = mll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
