package com.bl.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bl.common.FormatUtil;

public class BlStore implements Serializable,RowMapper<BlStore> {

	/**
	 * 库存
	 */
	private static final long serialVersionUID = -3076406256754174374L;
	private String bl_store_id; 
	private String bl_id;
	private String bl_name;
	private String sh_id; 
	private String sh_name; 
	private String ss_id;
	private String ss_name;
	private String bl_store_date; 
	private Long bl_store_num;
	public String getBl_store_id() {
		return bl_store_id;
	}
	public void setBl_store_id(String bl_store_id) {
		this.bl_store_id = bl_store_id;
	}
	public String getBl_id() {
		return bl_id;
	}
	public void setBl_id(String bl_id) {
		this.bl_id = bl_id;
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
	public String getBl_store_date() {
		return bl_store_date;
	}
	public void setBl_store_date(String bl_store_date) {
		this.bl_store_date = bl_store_date;
	}
	public Long getBl_store_num() {
		return bl_store_num;
	}
	public void setBl_store_num(Long bl_store_num) {
		this.bl_store_num = bl_store_num;
	}
	@Override
	public BlStore mapRow(ResultSet rs, int i) throws SQLException {
		BlStore bean = new BlStore();
		bean.setBl_id(rs.getString("bl_id"));
		bean.setBl_name(rs.getString("bl_name"));
		bean.setBl_store_date(FormatUtil.DateToStr(rs.getDate("bl_store_date"), "yyyy-MM-dd HH:mm:ss"));
		bean.setBl_store_id(rs.getString("bl_store_id"));
		bean.setBl_store_num(rs.getLong("bl_store_num"));
		bean.setSh_id(rs.getString("sh_id"));
		bean.setSh_name(rs.getString("sh_name"));
		bean.setSs_id(rs.getString("ss_id"));
		bean.setSs_name(rs.getString("ss_name"));
		return bean;
	}
}
