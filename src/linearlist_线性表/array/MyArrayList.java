package linearlist_线性表.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayList实现
 *
 * @param <E>
 */
public class MyArrayList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 包含元素的ArrayList大小
     */
    private int size;

    private E[] elementData;


    public MyArrayList() {
        size = 0;
        elementData = newArr(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public E[] newArr(int capacity) {
        return (E[]) new Object[capacity];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }


    public int size() {
        return size;
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
        return elementData[idx];
    }

    public E set(int idx, E newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E old = elementData[idx];
        elementData[idx] = newVal;
        return old;
    }

    public boolean add(E newVal) {
        add(size(), newVal);
        return true;
    }

    public void add(int idx, E element) {
        // 容量已存满, 扩容
        if (elementData.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        // 移动要插入索引位置后的元素
        for (int i = size(); i > idx; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[idx] = element;
        size++;
    }

    public E remove(int idx) {
        E removeItem = elementData[idx];
        // 移动被删除索引后面的元素
        for (int i = idx; i < size() - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        return removeItem;
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }

        E[] old = elementData;
        elementData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            elementData[i] = old[i];
        }
    }

    public void printAll() {
        for (Iterator iterator = this.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
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
            return elementData[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current--);
        }
    }


    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.printAll();

        list.add("a");
        list.add('b');
        list.printAll();

        for (int i = list.size(); i > 2; i--) {
            list.remove(i);
        }
        list.printAll();

        list.clear();
        list.printAll();
    }
}
