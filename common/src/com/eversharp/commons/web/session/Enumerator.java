/*
 *Copyright(C) 2012 www.eversharp.cn
 *All right reserved.
 */
package com.eversharp.commons.web.session;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * description:封装人集合操作
 * 
 * @author wu_quanyin(wuquanyin1201@gmail.com)
 * @version 1.0
 * @date 2012-7-10
 */
public class Enumerator<E> implements Enumeration<E> {

	// ----------------------------------------------------------- Constructors

	// ----------------------------------------------------- Instance Variables
	private Iterator<E>	iterator	= null;

	/**
	 * 添加集合
	 * 
	 * @param collection
	 */
	public Enumerator(Collection<E> collection) {

		this(collection.iterator());

	}

	/**
	 * 是否拷贝一份
	 * 
	 * @param collection
	 * @param clone
	 */
	public Enumerator(Collection<E> collection, boolean clone) {

		this(collection.iterator(), clone);

	}

	/**
	 * 迭代器的操作
	 * 
	 * @param iterator
	 */
	public Enumerator(Iterator<E> iterator) {

		super();
		this.iterator = iterator;

	}

	/**
	 * 判断是否拷贝的一份的操作
	 * 
	 * @param iterator
	 * @param clone
	 */
	public Enumerator(Iterator<E> iterator, boolean clone) {

		super();
		if (!clone) {
			this.iterator = iterator;
		} else {
			List<E> list = new ArrayList<E>();
			while (iterator.hasNext()) {
				list.add(iterator.next());
			}
			this.iterator = list.iterator();
		}

	}

	public Enumerator(Map<String, E> map) {

		this(map.values().iterator());

	}

	public Enumerator(Map<String, E> map, boolean clone) {

		this(map.values().iterator(), clone);

	}

	// --------------------------------------------------------- Public Methods

	public boolean hasMoreElements() {

		return (iterator.hasNext());

	}

	public E nextElement() throws NoSuchElementException {

		return (iterator.next());

	}

}
