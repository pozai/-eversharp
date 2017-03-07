/*
 *Copyright(C) 2012 www.eversharp.cn
 *All right reserved.
 */
package com.eversharp.commons.web.session;

import java.util.HashMap;
import java.util.Map;

import com.eversharp.commons.cache.CacheFactory;
import com.eversharp.commons.cache.ICache;

/**
 * description:session缓存到内存中(可用于分布式存储)
 * 
 * @author wu_quanyin(wuquanyin1201@gmail.com)
 * @version 1.0
 * @date 2012-7-10
 */
public class SessionService {


	/** 所要存放的缓存  */
	private ICache<String, Map<String, Object>>	cache		= null;
	
	/** 单例实现 */
	private static final SessionService instance =new SessionService();
	
	/**
	 * 通过这个改变cache对象
	 */
	private SessionService() {
		cache = CacheFactory.getSessionCache();
	}

	/**
	 * 获取单例实例 
	 * 
	 * @return
	 */
	public static synchronized SessionService getInstance() {

		return instance;
	}


	public Map<String, Object> getSession(String id) {
		Map<String, Object> session = cache.get(id);
		if (session == null) {
			session = new HashMap<String, Object>();
			cache.add(id, session);
		}
		return session;
	}

	public void saveSession(String id, Map<String, Object> session) {
		cache.add(id, session);
	}

	public void removeSession(String id) {
		cache.remove(id);
	}

	protected void finalize() {

	}

}
