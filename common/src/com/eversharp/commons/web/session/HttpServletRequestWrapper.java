/*
 *Copyright(C) 2012 www.eversharp.cn
 *All right reserved.
 */
package com.eversharp.commons.web.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * description:request获取session的封装，继承自javax.servlet.http.HttpServletRequestWrapper
 * 
 * @author wu_quanyin(wuquanyin1201@gmail.com)
 * @version 1.0
 * @date 2012-7-10
 */
public class HttpServletRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper {

	//sessionid的
	String	sessionid	= "";

	public HttpServletRequestWrapper(String sessionid, HttpServletRequest arg0) {
		super(arg0);
		this.sessionid = sessionid;
	}

	public HttpSession getSession(boolean create) {
		return new HttpSessionSidWrapper(this.sessionid, super.getSession(create));
	}

	public HttpSession getSession() {
		return new HttpSessionSidWrapper(this.sessionid, super.getSession());
	}

}
