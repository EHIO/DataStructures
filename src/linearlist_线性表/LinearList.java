package linearlist_线性表;

public interface LinearList {
	/**在线性表的指定位置插入指定元素*/
	boolean add(int index, Object element);

	/**向线性表的尾部添加指定的元素*/
	boolean add(Object element);

	/**移除线性表中指定位置的元素*/
	Object remove(int index);

	/**用指定元素替换线性表中指定位置的元素*/
	Object set(int index, Object element);

	/**返回索引为index的元素*/
	Object get(int index);

	/** 返回线性表元素数量 */
	int size();

	/** 判断线性表是否为空 */
	boolean isEmpty();

	/** 清空线性表 */
	void clear();
}
