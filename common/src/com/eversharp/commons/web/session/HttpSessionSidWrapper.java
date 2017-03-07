/*
 *Copyright(C) 2012 www.eversharp.cn
 *All right reserved.
 */
package com.eversharp.commons.web.session;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * description:每一个sid封装于这个类
 * 
 * <p>这个封装操作的是缓存中的数据</p>
 * 
 * @author wu_quanyin(wuquanyin1201@gmail.com)
 * @version 1.0
 * @date 2012-7-10
 */
public class HttpSessionSidWrapper extends HttpSessionWrapper {

	private String				sessionid	= "";

	private Map<String, Object>	map	= null;

	public HttpSessionSidWrapper(String sessionid, HttpSession session) {
		super(session);
		this.sessionid = sessionid;
		this.map = SessionService.getInstance().getSession(sessionid);
	}

	public Object getAttribute(String arg0) {
		return this.map.get(arg0);
	}

	public Enumeration<String> getAttributeNames() {
		return (new Enumerator<String>(this.map.keySet(), true));
	}

	public void invalidate() {
		this.map.clear();
		SessionService.getInstance().removeSession(this.sessionid);
	}

	public void removeAttribute(String arg0) {
		this.map.remove(arg0);
		SessionService.getInstance().saveSession(this.sessionid, this.map);
	}

	public void setAttribute(String key, Object value) {
		this.map.put(key, value);
		SessionService.getInstance().saveSession(this.sessionid, this.map);
	}

}
