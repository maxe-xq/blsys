package com.bl.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author qiang.xiong
 * @version 创建时间：2014年10月29日 下午12:53:06
 */
public class BlCompany implements Serializable,RowMapper<BlCompany>{
	private static final long serialVersionUID = 7398600600274559642L;
	private String com_id;
	private String com_name; 
	private String com_tel;
	private String com_addr;
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCom_tel() {
		return com_tel;
	}
	public void setCom_tel(String com_tel) {
		this.com_tel = com_tel;
	}
	public String getCom_addr() {
		return com_addr;
	}
	public void setCom_addr(String com_addr) {
		this.com_addr = com_addr;
	}
	@Override
	public BlCompany mapRow(ResultSet rs, int arg1) throws SQLException {
		BlCompany bean = new BlCompany();
		bean.setCom_addr(rs.getString("com_addr"));
		bean.setCom_tel(rs.getString("com_tel"));
		bean.setCom_id(rs.getString("com_id"));
		bean.setCom_name(rs.getString("com_name"));
		return bean;
	}
}
