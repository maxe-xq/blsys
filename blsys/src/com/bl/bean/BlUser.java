package com.bl.bean;

import java.io.Serializable;

public class BlUser implements Serializable{
	/**
	 * 用户信息
	 */
	private static final long serialVersionUID = -2927139152800912880L;
	private String user_id;
	private String user_name; 
	private String user_password; 
	private String user_mobile; 
	private String user_telephone; 
	private String user_addr; 
	private String user_com_id; 
	private String user_com_name; 
	private String user_qq; 
	private String user_email; 
	private String user_weixin; 
	private String user_sex; 
	private String user_status; 
	private String user_type;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	public String getUser_telephone() {
		return user_telephone;
	}
	public void setUser_telephone(String user_telephone) {
		this.user_telephone = user_telephone;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	
	public String getUser_com_id() {
		return user_com_id;
	}
	public void setUser_com_id(String user_com_id) {
		this.user_com_id = user_com_id;
	}
	public String getUser_com_name() {
		return user_com_name;
	}
	public void setUser_com_name(String user_com_name) {
		this.user_com_name = user_com_name;
	}
	public String getUser_qq() {
		return user_qq;
	}
	public void setUser_qq(String user_qq) {
		this.user_qq = user_qq;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_weixin() {
		return user_weixin;
	}
	public void setUser_weixin(String user_weixin) {
		this.user_weixin = user_weixin;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
}
