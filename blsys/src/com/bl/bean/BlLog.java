package com.bl.bean;

import java.io.Serializable;

public class BlLog implements Serializable {

	/**
	 * 日志
	 */
	private static final long serialVersionUID = 1332893164739805130L;
	private String bl_log_id; 
	private String bl_user_id; 
	private String bl_log_date; 
	private String bl_log_opt;
	public String getBl_log_id() {
		return bl_log_id;
	}
	public void setBl_log_id(String bl_log_id) {
		this.bl_log_id = bl_log_id;
	}
	public String getBl_user_id() {
		return bl_user_id;
	}
	public void setBl_user_id(String bl_user_id) {
		this.bl_user_id = bl_user_id;
	}
	public String getBl_log_date() {
		return bl_log_date;
	}
	public void setBl_log_date(String bl_log_date) {
		this.bl_log_date = bl_log_date;
	}
	public String getBl_log_opt() {
		return bl_log_opt;
	}
	public void setBl_log_opt(String bl_log_opt) {
		this.bl_log_opt = bl_log_opt;
	}
}
