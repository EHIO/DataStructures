package linearlist_线性表;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {

    private static int DEFAULT_CAPACITY = 10;

    private int theSize;

    private E[] theItems;


    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public E get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public E set(int idx, E newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public boolean add(E newVal) {
        add(size(), newVal);
        return true;
    }

    public void add(int idx, E newVal) {
        // 容量已满, 扩容
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        // 移动要插入索引位置后的元素
        for (int i = size(); i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = newVal;
        theSize++;
    }

    public E remove(int idx) {
        E removeItem = theItems[idx];
        // 移动被删除索引后面的元素
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removeItem;
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }

        E[] old = theItems;
        theItems = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }


    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current--);
        }
    }
}
