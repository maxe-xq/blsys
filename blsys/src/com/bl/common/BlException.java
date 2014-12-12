package com.bl.common;
/**
 * @author qiang.xiong
 * @version 创建时间：2014年10月16日 下午2:36:00
 */
public class BlException extends RuntimeException {

	private static final long serialVersionUID = -7750476613695725649L;
	
	public BlException() {
		super();
	}
	public BlException(String message, Throwable cause) {
		super(message, cause);
	}
	public BlException(String message) {
		super(message);
	}
	public BlException(Throwable cause) {
		super(cause);
	}
}
