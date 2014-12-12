package com.bl.bean;

import java.io.Serializable;
import java.util.List;

public class BlOrder implements Serializable{

	/**
	 * 操作
	 */
	private static final long serialVersionUID = -2917194106857539143L;
	private String bl_order_id; 
	private String bl_custom_id; 
	private String bl_user_id; 
	private String bl_order_opt; 
	private String bl_order_date; 
	private Long bl_order_num; 
	private Double bl_order_price; 
	private Double bl_order_pay; 
	private String bl_order_status;
	private List<BlOrderItem> items;
	
	public List<BlOrderItem> getItems() {
		return items;
	}
	public void setItems(List<BlOrderItem> items) {
		this.items = items;
	}
	public String getBl_order_id() {
		return bl_order_id;
	}
	public void setBl_order_id(String bl_order_id) {
		this.bl_order_id = bl_order_id;
	}
	public String getBl_custom_id() {
		return bl_custom_id;
	}
	public void setBl_custom_id(String bl_custom_id) {
		this.bl_custom_id = bl_custom_id;
	}
	public String getBl_user_id() {
		return bl_user_id;
	}
	public void setBl_user_id(String bl_user_id) {
		this.bl_user_id = bl_user_id;
	}
	public String getBl_order_opt() {
		return bl_order_opt;
	}
	public void setBl_order_opt(String bl_order_opt) {
		this.bl_order_opt = bl_order_opt;
	}
	public String getBl_order_date() {
		return bl_order_date;
	}
	public void setBl_order_date(String bl_order_date) {
		this.bl_order_date = bl_order_date;
	}
	public Long getBl_order_num() {
		return bl_order_num;
	}
	public void setBl_order_num(Long bl_order_num) {
		this.bl_order_num = bl_order_num;
	}
	public Double getBl_order_price() {
		return bl_order_price;
	}
	public void setBl_order_price(Double bl_order_price) {
		this.bl_order_price = bl_order_price;
	}
	public Double getBl_order_pay() {
		return bl_order_pay;
	}
	public void setBl_order_pay(Double bl_order_pay) {
		this.bl_order_pay = bl_order_pay;
	}
	public String getBl_order_status() {
		return bl_order_status;
	}
	public void setBl_order_status(String bl_order_status) {
		this.bl_order_status = bl_order_status;
	}
}
