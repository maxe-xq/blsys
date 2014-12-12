package com.bl.bean;

import java.io.Serializable;

public class BlStoreHouse implements Serializable{

	/**
	 * 仓库
	 */
	private static final long serialVersionUID = -8832094176125161167L;
	private String sh_id; //编号
	private String sh_name;  //名称
	private String sh_position;  //方位
	private String sh_desc;  //描述
	private String sh_deptno;  //部门
	private String sh_deptname;  //部门名称
	private String sh_section_no;  //区域
	private String sh_section_name; //区域
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
	public String getSh_position() {
		return sh_position;
	}
	public void setSh_position(String sh_position) {
		this.sh_position = sh_position;
	}
	public String getSh_desc() {
		return sh_desc;
	}
	public void setSh_desc(String sh_desc) {
		this.sh_desc = sh_desc;
	}
	public String getSh_deptno() {
		return sh_deptno;
	}
	public void setSh_deptno(String sh_deptno) {
		this.sh_deptno = sh_deptno;
	}
	public String getSh_deptname() {
		return sh_deptname;
	}
	public void setSh_deptname(String sh_deptname) {
		this.sh_deptname = sh_deptname;
	}
	public String getSh_section_no() {
		return sh_section_no;
	}
	public void setSh_section_no(String sh_section_no) {
		this.sh_section_no = sh_section_no;
	}
	public String getSh_section_name() {
		return sh_section_name;
	}
	public void setSh_section_name(String sh_section_name) {
		this.sh_section_name = sh_section_name;
	}
}
