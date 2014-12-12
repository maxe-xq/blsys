package com.bl.bean;

import java.io.Serializable;

public class BlDic implements Serializable {

	/**
	 * 字典
	 */
	private static final long serialVersionUID = -1061575561380583083L;
	private String bl_dic_id; 
	private String bl_table; 
	private String bl_column; 
	private String bl_name; 
	private String bl_value; 
	private String bl_order;
	public String getBl_dic_id() {
		return bl_dic_id;
	}
	public void setBl_dic_id(String bl_dic_id) {
		this.bl_dic_id = bl_dic_id;
	}
	public String getBl_table() {
		return bl_table;
	}
	public void setBl_table(String bl_table) {
		this.bl_table = bl_table;
	}
	public String getBl_column() {
		return bl_column;
	}
	public void setBl_column(String bl_column) {
		this.bl_column = bl_column;
	}
	public String getBl_name() {
		return bl_name;
	}
	public void setBl_name(String bl_name) {
		this.bl_name = bl_name;
	}
	public String getBl_value() {
		return bl_value;
	}
	public void setBl_value(String bl_value) {
		this.bl_value = bl_value;
	}
	public String getBl_order() {
		return bl_order;
	}
	public void setBl_order(String bl_order) {
		this.bl_order = bl_order;
	}
}
