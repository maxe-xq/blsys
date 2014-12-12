package com.bl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.bl.common.BlException;
import com.bl.common.FormatUtil;
import com.bl.common.JsonHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	protected long page = 1L;
	protected long pagesize = 10L;

	public BaseAction() {
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public String getHostAddress() {
		String _hostAddress = null;
		try {
			_hostAddress = InetAddress.getLocalHost().getHostAddress()
					.toLowerCase();
			if (_hostAddress.equals("localhost")
					|| _hostAddress.equals("127.0.0.1")) {
				for (Enumeration e1 = NetworkInterface.getNetworkInterfaces(); e1
						.hasMoreElements();) {
					NetworkInterface ni = (NetworkInterface) e1.nextElement();
					if (ni.getName().equals("eth0")) {
						for (Enumeration e2 = ni.getInetAddresses(); e2
								.hasMoreElements();) {
							InetAddress ia = (InetAddress) e2.nextElement();
							if (!(ia instanceof Inet6Address))
								_hostAddress = ia.getHostAddress();
						}

						break;
					}
				}

			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return _hostAddress;
	}

	public String getRemoteAddr() {
		HttpServletRequest request = getRequest();
		String ip = (String) request.getSession().getAttribute(
				"SessionRemoteAddr");
		if (StringUtils.isNotBlank(ip)) {
			return ip;
		} else {
			ip = request.getHeader("x-forwarded-for");
			if (StringUtils.isEmpty(ip)) {
				String serv = request.getServerName();
				if ("localhost".equals(serv) || "127.0.0.1".equals(serv))
					return getHostAddress();
			} else if ("localhost".equals(ip) || "127.0.0.1".equals(ip))
				return getHostAddress();
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("Proxy-Client-IP");
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("WL-Proxy-Client-IP");
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
				ip = request.getRemoteAddr();
			if (StringUtils.isNotBlank(ip)) {
				int pos = ip.indexOf(",");
				if (pos > 0)
					ip = ip.substring(0, pos).trim();
			}
			request.getSession().setAttribute("SessionRemoteAddr", ip);
			return ip;
		}
	}

	public String getParameter(String name, String defaultValue) {
		String value = getRequest().getParameter(name);
		if (FormatUtil.isEmptyString(value))
			return defaultValue;
		else
			return value;
	}

	public String[] getParameterValues(String name) {
		return getRequest().getParameterValues(name);
	}

	public void setAttribute(String name, Object value) {
		getRequest().setAttribute(name, value);
	}

	public Object getAttribute(String name) {
		return getAttribute(name, null);
	}

	public Object getAttribute(String name, Object defaultValue) {
		Object value = getRequest().getAttribute(name);
		return value != null ? value : defaultValue;
	}

	public Object getSession(String name) {
		return getSession(name, null);
	}

	public Object getSession(String name, Object defaultValue) {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		Object value = session.get(name);
		return value != null ? value : defaultValue;
	}

	public void setSession(Object name, Object value) {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		session.put(name, value);
	}

	public void setPage(String page) {
		if (!FormatUtil.isEmptyString(page))
			this.page = Long.parseLong(page);
	}

	public void setPagesize(String pagesize) {
		if (!FormatUtil.isEmptyString(pagesize))
			this.pagesize = Long.parseLong(pagesize);
	}
	protected void outputResult(Object obj){
		String rs = JsonHelper.toJson(obj);
		HttpServletResponse response = getResponse();
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(rs);
		} catch (IOException e) {
			throw new BlException(e.getMessage());
		}
	}
}