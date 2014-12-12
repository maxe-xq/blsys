package com.bl.bean;

import java.io.Serializable;

public class BlOrderItem implements Serializable {

	/**
	 * 详情
	 */
	private static final long serialVersionUID = -8522620040996824205L;
	private String bl_item_id; 
	private String bl_order_id; 
	private String bl_id; 
	private String bl_name;
	private String sh_id; 
	private String sh_name; 
	private String ss_id;
	private String ss_name;
	private Long bl_num; 
	private Double bl_price;
	public String getBl_item_id() {
		return bl_item_id;
	}
	public void setBl_item_id(String bl_item_id) {
		this.bl_item_id = bl_item_id;
	}
	public String getBl_order_id() {
		return bl_order_id;
	}
	public void setBl_order_id(String bl_order_id) {
		this.bl_order_id = bl_order_id;
	}
	public String getBl_id() {
		return bl_id;
	}
	public void setBl_id(String bl_id) {
		this.bl_id = bl_id;
	}
	public Long getBl_num() {
		return bl_num;
	}
	public void setBl_num(Long bl_num) {
		this.bl_num = bl_num;
	}
	public Double getBl_price() {
		return bl_price;
	}
	public void setBl_price(Double bl_price) {
		this.bl_price = bl_price;
	}
	public String getBl_name() {
		return bl_name;
	}
	public void setBl_name(String bl_name) {
		this.bl_name = bl_name;
	}
	public String getSh_id() {
		return sh_id;
	}
	public void setSh_id(String sh_id) {
		this.sh_id = sh_id;
	}
	public String getSh_name() {
		return sh_name;
	}
	public void setSh_name(String sh_name) {
		this.sh_name = sh_name;
	}
	public String getSs_id() {
		return ss_id;
	}
	public void setSs_id(String ss_id) {
		this.ss_id = ss_id;
	}
	public String getSs_name() {
		return ss_name;
	}
	public void setSs_name(String ss_name) {
		this.ss_name = ss_name;
	}
}
