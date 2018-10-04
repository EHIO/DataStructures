package linearlist_线性表.impl;


import linearlist_线性表.LinearList;

public class SequenceList implements LinearList {
	/**存储线性表元素的容器*/
	private Object[] sList;
	/**实际存储元素的数量*/
	private int size;
	
	public SequenceList() {
		this(10);
	}

	public SequenceList(int length) {
		if(length < 0) {
			throw new IllegalArgumentException("Illegal Capacity: "+
				 length);
		} 
		sList = new Object[length];
	}

	@Override
	public boolean add(int index, Object element) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index:" + index + ",size:"
					+ size);
		}
		if(size == sList.length) {//如果存储线性表元素的容器没有容量
			Object[] temp = sList;//将原容器赋值给新创建的中间数组容器
			this.sList = new Object[sList.length * 2];//重新申请一个容量更大的容器
			for(int i = 0, j = temp.length; i < j; i++) {//复制数组元素
				sList[i] = temp[i];
			}
		}
		for(int i = size - 1; i >= index; i--) {//元素后移
			sList[i + 1] = sList[i];
		}
		sList[index] = element;//插入元素
		size++;//元素的个数增加一个
		return true;
	}

	@Override
	public boolean add(Object element) {
		return add(size, element);
	}

	public Object remove(int index) {
		 checkIndex(index);
		 Object oleEle = sList[index];
		 for(int i = 0; i < size; i++) {
			 sList[i] = sList[i + 1];
		 }
		 sList[size--] = null;
		return oleEle;
	}

	@Override
	public Object set(int index, Object element) {
		checkIndex(index);//检查索引的合法性
		Object oldEle = sList[index];//获取要替换的元素
		sList[index] = element;//替换元素
		return oldEle;
	}

	@Override
	public Object get(int index) {
		checkIndex(index);
		return sList[index];
	}

	
	public int size() {

		return size;
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public void clear() {
		if(size != 0) {
			for (int i = 0; i < size; i++) {
				sList[i] = null;
			}
		}
		size = 0;
	}
	/**
	 * 删改查需要判断索引的合法性
	 * @param index
	 */
	public void checkIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index:" + index + ",size:"
					+ size);
		}
	}

	public Object[] getsList() {
		return sList;
	}

	public void setsList(Object[] sList) {
		this.sList = sList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
