/*
 *Copyright(C) 2012 www.eversharp.cn
 *All right reserved.
 */
package com.eversharp.commons.web.session;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * description:对session进行封装
 * <p>
 * 这个封装的session操作的还是原先服务器的session
 * </p>
 * 
 * @author wu_quanyin(wuquanyin1201@gmail.com)
 * @version 1.0
 * @date 2011-7-18
 */
@SuppressWarnings("deprecation")
public class HttpSessionWrapper implements HttpSession {

	/** session类 */
	private HttpSession	session;

	public HttpSessionWrapper(HttpSession session) {
		this.session = session;
	}

	public Object getAttribute(String key) {
		return this.session.getAttribute(key);
	}
	@SuppressWarnings({ })
	public Enumeration<String> getAttributeNames() {
		return this.session.getAttributeNames();
	}

	public long getCreationTime() {
		return session.getCreationTime();
	}

	public String getId() {
		return session.getId();
	}

	public long getLastAccessedTime() {
		return session.getLastAccessedTime();
	}

	public int getMaxInactiveInterval() {
		return session.getMaxInactiveInterval();
	}

	public ServletContext getServletContext() {
		return session.getServletContext();
	}

	public HttpSessionContext getSessionContext() {
		return session.getSessionContext();
	}

	public Object getValue(String arg0) {
		return session.getValue(arg0);
	}

	public String[] getValueNames() {
		return session.getValueNames();
	}

	public void invalidate() {
		this.session.invalidate();
	}

	public boolean isNew() {
		return session.isNew();
	}

	public void putValue(String arg0, Object arg1) {
		session.putValue(arg0, arg1);
	}

	public void removeAttribute(String arg0) {
		this.session.removeAttribute(arg0);
	}

	public void removeValue(String arg0) {
		session.removeValue(arg0);
	}

	public void setAttribute(String arg0, Object arg1) {
		this.session.setAttribute(arg0, arg1);
	}

	public void setMaxInactiveInterval(int arg0) {
		session.setMaxInactiveInterval(arg0);
	}

}
