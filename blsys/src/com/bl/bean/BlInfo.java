package com.bl.bean;

import java.io.Serializable;

public class BlInfo implements Serializable{

	/**
	 * 玻璃详细信息
	 */
	private static final long serialVersionUID = -7571745609284747079L;
	private String bl_id; //编号
	private String bl_format;//规格
	private String bl_uom;//计量单位
	private String bl_name; //名称
	private Double bl_area; //面积
	private Double bl_oldprice; //原价
	private String bl_crafts; //工艺：钢化、夹层
	private String bl_car_brand; //汽车品牌：
	private String bl_color; //颜色
	private String bl_door_direct; //门方向：前挡、后档、左前、左后、右前、右后、左中、右中
	private String bl_height; //高度
	private String bl_width; //宽度
	private String bl_thickness; //厚度
	private String bl_radian_up; //弧度上
	private String bl_radian_thickness; //弧度厚度
	private String bl_radian_width_up; //弧度上宽
	private String bl_radian_down; //弧度下
	private String bl_radian_height_center; //中高
	private String bl_radian_width_down; //弧度下宽
	private String bl_radian_height_left; //左弧高
	private String bl_black_edge; //黑边
	private String bl_has_hole; //是否有孔
	private String bl_hole_direct; //孔位置
	private String bl_hole_num; //孔数目
	private String bl_blue_edge; //蓝边
	private String bl_brand; //商标
	private String bl_origin; //产地
	private String bl_create_date; //生产日期
	public String getBl_format() {
		return bl_format;
	}
	public void setBl_format(String bl_format) {
		this.bl_format = bl_format;
	}
	public String getBl_uom() {
		return bl_uom;
	}
	public void setBl_uom(String bl_uom) {
		this.bl_uom = bl_uom;
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
	public String getBl_crafts() {
		return bl_crafts;
	}
	public void setBl_crafts(String bl_crafts) {
		this.bl_crafts = bl_crafts;
	}
	public String getBl_car_brand() {
		return bl_car_brand;
	}
	public void setBl_car_brand(String bl_car_brand) {
		this.bl_car_brand = bl_car_brand;
	}
	public String getBl_color() {
		return bl_color;
	}
	public void setBl_color(String bl_color) {
		this.bl_color = bl_color;
	}
	public String getBl_door_direct() {
		return bl_door_direct;
	}
	public void setBl_door_direct(String bl_door_direct) {
		this.bl_door_direct = bl_door_direct;
	}
	public String getBl_height() {
		return bl_height;
	}
	public void setBl_height(String bl_height) {
		this.bl_height = bl_height;
	}
	public String getBl_width() {
		return bl_width;
	}
	public void setBl_width(String bl_width) {
		this.bl_width = bl_width;
	}
	public String getBl_thickness() {
		return bl_thickness;
	}
	public void setBl_thickness(String bl_thickness) {
		this.bl_thickness = bl_thickness;
	}
	public Double getBl_area() {
		return bl_area;
	}
	public void setBl_area(Double bl_area) {
		this.bl_area = bl_area;
	}
	public Double getBl_oldprice() {
		return bl_oldprice;
	}
	public void setBl_oldprice(Double bl_oldprice) {
		this.bl_oldprice = bl_oldprice;
	}
	public String getBl_radian_up() {
		return bl_radian_up;
	}
	public void setBl_radian_up(String bl_radian_up) {
		this.bl_radian_up = bl_radian_up;
	}
	public String getBl_radian_thickness() {
		return bl_radian_thickness;
	}
	public void setBl_radian_thickness(String bl_radian_thickness) {
		this.bl_radian_thickness = bl_radian_thickness;
	}
	public String getBl_radian_width_up() {
		return bl_radian_width_up;
	}
	public void setBl_radian_width_up(String bl_radian_width_up) {
		this.bl_radian_width_up = bl_radian_width_up;
	}
	public String getBl_radian_down() {
		return bl_radian_down;
	}
	public void setBl_radian_down(String bl_radian_down) {
		this.bl_radian_down = bl_radian_down;
	}
	public String getBl_radian_height_center() {
		return bl_radian_height_center;
	}
	public void setBl_radian_height_center(String bl_radian_height_center) {
		this.bl_radian_height_center = bl_radian_height_center;
	}
	public String getBl_radian_width_down() {
		return bl_radian_width_down;
	}
	public void setBl_radian_width_down(String bl_radian_width_down) {
		this.bl_radian_width_down = bl_radian_width_down;
	}
	public String getBl_radian_height_left() {
		return bl_radian_height_left;
	}
	public void setBl_radian_height_left(String bl_radian_height_left) {
		this.bl_radian_height_left = bl_radian_height_left;
	}
	public String getBl_black_edge() {
		return bl_black_edge;
	}
	public void setBl_black_edge(String bl_black_edge) {
		this.bl_black_edge = bl_black_edge;
	}
	public String getBl_has_hole() {
		return bl_has_hole;
	}
	public void setBl_has_hole(String bl_has_hole) {
		this.bl_has_hole = bl_has_hole;
	}
	public String getBl_hole_direct() {
		return bl_hole_direct;
	}
	public void setBl_hole_direct(String bl_hole_direct) {
		this.bl_hole_direct = bl_hole_direct;
	}
	public String getBl_hole_num() {
		return bl_hole_num;
	}
	public void setBl_hole_num(String bl_hole_num) {
		this.bl_hole_num = bl_hole_num;
	}
	public String getBl_blue_edge() {
		return bl_blue_edge;
	}
	public void setBl_blue_edge(String bl_blue_edge) {
		this.bl_blue_edge = bl_blue_edge;
	}
	public String getBl_brand() {
		return bl_brand;
	}
	public void setBl_brand(String bl_brand) {
		this.bl_brand = bl_brand;
	}
	public String getBl_origin() {
		return bl_origin;
	}
	public void setBl_origin(String bl_origin) {
		this.bl_origin = bl_origin;
	}
	public String getBl_create_date() {
		return bl_create_date;
	}
	public void setBl_create_date(String bl_create_date) {
		this.bl_create_date = bl_create_date;
	}
	
}
