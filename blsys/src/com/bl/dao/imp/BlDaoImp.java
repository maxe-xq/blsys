package com.bl.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.bl.bean.BlCompany;
import com.bl.bean.BlInfo;
import com.bl.bean.BlOrder;
import com.bl.bean.BlOrderItem;
import com.bl.bean.BlStore;
import com.bl.bean.PageList;
import com.bl.common.FormatUtil;
import com.bl.dao.BlDao;

@Repository("BlDao")
public class BlDaoImp implements BlDao {
	
	@Autowired
    private transient JdbcTemplate jdbcTemplate;

	@Autowired
    private transient NamedParameterJdbcTemplate paramJdbcTemplate;
	
	/**
	 * 保存到操作表
	 */
	@Override
	public boolean addOrder(BlOrder blOrder) {
		String sql = "INSERT INTO bl_order(bl_order_id, bl_custom_id, bl_user_id, "
				+ "bl_order_opt, bl_order_date, bl_order_num, bl_order_price, "
				+ "bl_order_pay, bl_order_status) VALUES (:bl_order_id, :bl_custom_id, :bl_user_id, "
				+ ":bl_order_opt, to_date(:bl_order_date,'yyyy-MM-dd hh24:mi:ss'), :bl_order_num, :bl_order_price, "
				+ ":bl_order_pay, :bl_order_status)";
		return paramJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(blOrder))>0?true:false;
	}
	
	/**
	 * 保存详情表
	 */
	@Override
	public boolean addOrderItem(BlOrderItem blOrderItem) {
		String sql = "INSERT INTO bl_order_item(bl_item_id, bl_order_id, bl_id, bl_num, bl_price) "
				+ "VALUES (:bl_item_id, :bl_order_id, :bl_id, :bl_num, :bl_price)";
		return paramJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(blOrderItem))>0?true:false;
	}
	
	/**
	 * 批量保存详情表
	 */
	@Override
	public boolean batchAddOrderItem(List<BlOrderItem> items) {
		String sql = "INSERT INTO bl_order_item(bl_item_id, bl_order_id, bl_id, bl_num, bl_price) "
				+ "VALUES (:bl_item_id, :bl_order_id, :bl_id, :bl_num, :bl_price)";
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils
				.createBatch(items.toArray());
		return paramJdbcTemplate.batchUpdate(sql, batchArgs).length>0?true:false;
	}
	
	/**
	 * 根据操作类型更改库存
	 */
	public boolean batchUpdateStore(List<BlStore> stores){
		String sql = "UPDATE bl_store SET bl_store_date=to_date(:bl_store_date,'yyyy-MM-dd hh24:mi:ss'),"
				+ "bl_store_num=:bl_store_num where bl_id=:bl_id and sh_id=:sh_id and ss_id=:ss_id";
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils
				.createBatch(stores.toArray());
		return paramJdbcTemplate.batchUpdate(sql, batchArgs).length>0?true:false;
	}

	@Override
	public boolean updateOrder(BlOrder blOrder) {
		String sql = "UPDATE bl_order SET bl_custom_id=:bl_custom_id,"
				+ "bl_user_id=:bl_user_id,bl_order_opt=:bl_order_opt,bl_order_date=:bl_order_date,"
				+ "bl_order_num=:bl_order_num,bl_order_price=:bl_order_price,bl_order_pay=:bl_order_pay,"
				+ "bl_order_status=:bl_order_status WHERE bl_order_id=:bl_order_id";
		return paramJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(blOrder))>0?true:false;
	}

	@Override
	public boolean deleteOrder(String bl_order_id) {
		String sql = "DELETE FROM bl_order WHERE bl_order_id=?";
		return jdbcTemplate.update(sql, bl_order_id)>0?true:false;
	}

	@Override
	public boolean updateOrderItem(BlOrderItem blOrderItem) {
		String sql = "UPDATE bl_order_item SET bl_order_id=:bl_order_id,"
				+ "bl_id=:bl_id,bl_num=:bl_num,bl_price=:bl_price WHERE bl_item_id=:bl_item_id";
		return paramJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(blOrderItem))>0?true:false;
	}

	@Override
	public boolean deleteOrderItem(String bl_item_id) {
		String sql = "DELETE FROM bl_order_item WHERE bl_item_id=?";
		return jdbcTemplate.update(sql, bl_item_id)>0?true:false;
	}

	@Override
	public boolean batchUpdateOrderItem(List<BlOrderItem> items) {
		String sql = "UPDATE bl_order_item SET bl_order_id=:bl_order_id,"
				+ "bl_id=:bl_id,bl_num=:bl_num,bl_price=:bl_price WHERE bl_item_id=:bl_item_id";
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(items.toArray());
		return paramJdbcTemplate.batchUpdate(sql, params).length>0?true:false;
	}

	@Override
	public boolean batchDeleteOrderItem(String[] args) {
		String sql = "DELETE FROM bl_order_item WHERE bl_item_id=:bl_item_id";
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(args);
		return paramJdbcTemplate.batchUpdate(sql, batchArgs).length>0?true:false;
	}

	@Override
	public boolean updateStore(BlStore store) {
		String sql = "UPDATE bl_store SET bl_store_date=to_date(:bl_store_date,'yyyy-MM-dd hh24:mi:ss'),"
				+ "bl_store_num=:bl_store_num where bl_id=:bl_id and sh_id=:sh_id and ss_id=:ss_id";
		return paramJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(store))>0?true:false;
	}

	@Override
	public boolean addStore(BlStore store) {
		String sql = "INSERT INTO bl_store(bl_store_id, bl_id, sh_id, ss_id, bl_store_date, bl_store_num) "
				+ "VALUES (:bl_store_id, :bl_id, :sh_id, :ss_id, :bl_store_date, :bl_store_num)";
		return paramJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(store))>0?true:false;
	}

	@Override
	public boolean batchAddStore(List<BlStore> stores) {
		String sql = "INSERT INTO bl_store(bl_store_id, bl_id, sh_id, ss_id, bl_store_date, bl_store_num) "
				+ "VALUES (:bl_store_id, :bl_id, :sh_id, :ss_id, :bl_store_date, :bl_store_num)";
		SqlParameterSource[] args = SqlParameterSourceUtils.createBatch(stores.toArray());
		return paramJdbcTemplate.batchUpdate(sql, args).length>0?true:false;
	}

	@Override
	public List<BlStore> queryStoreByConditions(Map<String, String> conditions) {
		String sql = "SELECT s.bl_store_id, s.bl_id, bl.bl_name, s.sh_id, sh.sh_name,"
				+ "s.ss_id, ss.ss_name, s.bl_store_date, s.bl_store_num FROM bl_store s"
				+ " INNER JOIN bl_info bl ON s.bl_id=bl.bl_id"
				+ " INNER JOIN bl_store_house sh ON s.sh_id=sh.sh_id"
				+ " LEFT JOIN bl_store_section ss ON s.sh_id=ss.ss_id"
				+ " WHERE 1=1";
		if(conditions!=null){
			if(!FormatUtil.isEmptyString(conditions.get("bl_id"))){
				sql += " AND s.bl_id='"+conditions.get("bl_id")+"'";
			}
			if(!FormatUtil.isEmptyString(conditions.get("sh_id"))){
				sql += " AND s.sh_id='"+conditions.get("sh_id")+"'";
			}
			if(!FormatUtil.isEmptyString(conditions.get("ss_id"))){
				sql += " AND s.ss_id='"+conditions.get("ss_id")+"'";
			}
		}
		
		sql += " ORDER BY s.bl_id,s.sh_id,s.ss_id";
		
		return jdbcTemplate.query(sql, new BlStore());
	}

	@Override
	public PageList<BlStore> queryStoreByConditions(long page, long pagesize,
			Map<String, String> conditions) {
		long start = (page-1)*pagesize;
		String condition_sql = "";
		String condition_sql1 = "";
		if(conditions!=null){
			if(!FormatUtil.isEmptyString(conditions.get("bl_id"))){
				condition_sql += " AND s.bl_id='"+conditions.get("bl_id")+"'";
				condition_sql1 += " AND s1.bl_id='"+conditions.get("bl_id")+"'";
			}
			if(!FormatUtil.isEmptyString(conditions.get("sh_id"))){
				condition_sql += " AND s.sh_id='"+conditions.get("sh_id")+"'";
				condition_sql1 += " AND s1.sh_id='"+conditions.get("sh_id")+"'";
			}
			if(!FormatUtil.isEmptyString(conditions.get("ss_id"))){
				condition_sql += " AND s.ss_id='"+conditions.get("ss_id")+"'";
				condition_sql1 += " AND s1.ss_id='"+conditions.get("ss_id")+"'";
			}
		}
		String page_sql = "SELECT s.bl_store_id, s.bl_id, bl.bl_name, s.sh_id, sh.sh_name,"
				+ "s.ss_id, ss.ss_name, s.bl_store_date, s.bl_store_num FROM bl_store s"
				+ " INNER JOIN bl_info bl ON s.bl_id=bl.bl_id"
				+ " INNER JOIN bl_store_house sh ON s.sh_id=sh.sh_id"
				+ " LEFT JOIN bl_store_section ss ON s.ss_id=ss.ss_id"
				+ " WHERE s.bl_store_id>=(SELECT s1.bl_store_id FROM bl_store s1"
				+ " INNER JOIN bl_info bl1 ON s1.bl_id=bl1.bl_id"
				+ " INNER JOIN bl_store_house sh1 ON s1.sh_id=sh1.sh_id"
				+ " LEFT JOIN bl_store_section ss1 ON s1.ss_id=ss1.ss_id " + condition_sql1
				+ " ORDER BY s1.bl_id,s1.sh_id,s1.ss_id  limit "+start+",1)"
				+ condition_sql + " ORDER BY s.bl_id,s.sh_id,s.ss_id limit " + pagesize;
		
		String total_sql = "SELECT count(s.bl_store_id) FROM bl_store s"
				+ " INNER JOIN bl_info bl ON s.bl_id=bl.bl_id"
				+ " INNER JOIN bl_store_house sh ON s.sh_id=sh.sh_id"
				+ " LEFT JOIN bl_store_section ss ON s.ss_id=ss.ss_id where 1=1 "+ condition_sql;
		Long total = jdbcTemplate.queryForObject(total_sql, Long.class);
		List<BlStore> list = jdbcTemplate.query(page_sql, new RowMapper<BlStore>(){
			@Override
			public BlStore mapRow(ResultSet rs, int i) throws SQLException {
				BlStore bean = new BlStore();
				bean.setBl_store_id(rs.getString("bl_store_id"));
				bean.setBl_id(rs.getString("bl_id"));
				bean.setBl_name(rs.getString("bl_name"));
				bean.setSh_id(rs.getString("sh_id"));
				bean.setSh_name(rs.getString("sh_name"));
				bean.setSs_id(rs.getString("ss_id"));
				bean.setSs_name(rs.getString("ss_name"));
				bean.setBl_store_date(rs.getString("bl_store_date"));
				bean.setBl_store_num(rs.getLong("bl_store_num"));
				return bean;
			}
		});
		PageList<BlStore> page_list = new PageList<BlStore>();
		page_list.setList(list);
		page_list.setTotal(total==null?0:total);
		page_list.setCurrs(page);
		page_list.setPageSize(pagesize);
		return page_list;
	}
	
	@Override
	public List<BlInfo> queryBlByConditions(Map<String, String> conditions) {
		String sql = "SELECT bl.bl_id, bl.bl_name FROM bl_info bl WHERE 1=1";
		if(conditions!=null){
			if(!FormatUtil.isEmptyString(conditions.get("bl_id"))){
				sql += " AND bl.bl_id='"+conditions.get("bl_id")+"'";
			}
			if(!FormatUtil.isEmptyString(conditions.get("bl_name"))){
				sql += " AND bl.bl_name='"+conditions.get("bl_name")+"'";
			}
		}
		sql += " ORDER BY bl.bl_id ";
		return jdbcTemplate.query(sql, new RowMapper<BlInfo>(){

			@Override
			public BlInfo mapRow(ResultSet rs, int i) throws SQLException {
				BlInfo bean = new BlInfo();
				bean.setBl_id(rs.getString("bl_id"));
				bean.setBl_name(rs.getString("bl_name"));
				return bean;
			}
			
		});
	}
	
	@Override
	public PageList<BlInfo> queryBlByConditions(long page, long pagesize,
			Map<String, String> conditions) {
		long start = (page-1)*pagesize;
		String condition_sql = "";
		if(conditions!=null){
			if(!FormatUtil.isEmptyString(conditions.get("bl_id"))){
				condition_sql += " AND bl.bl_id='"+conditions.get("bl_id")+"'";
			}
			if(!FormatUtil.isEmptyString(conditions.get("bl_name"))){
				condition_sql += " AND bl.bl_name='"+conditions.get("bl_name")+"'";
			}
		}
		
		String page_sql = "select bl.bl_id, bl.bl_name "
				+ "FROM bl_info bl WHERE bl.bl_id>="
				+ "(select b.bl_id from bl_info b where 1=1 "
				+condition_sql+" order by b.bl_id limit "+start+",1) "+condition_sql
				+" order by bl.bl_id limit "+pagesize;
		
		String total_sql = "SELECT count(1) FROM bl_info bl where 1=1 " + condition_sql; 
		Long total = jdbcTemplate.queryForObject(total_sql, Long.class);
		List<BlInfo> list = jdbcTemplate.query(page_sql, new RowMapper<BlInfo>(){
			@Override
			public BlInfo mapRow(ResultSet rs, int i) throws SQLException {
				BlInfo bean = new BlInfo();
				bean.setBl_id(rs.getString("bl_id"));
				bean.setBl_name(rs.getString("bl_name"));
				return bean;
			}
		});
		PageList<BlInfo> page_list = new PageList<BlInfo>();
		page_list.setList(list);
		page_list.setPageTotal(total==null?0:total);
		page_list.setCurrs(page);
		page_list.setPageSize(pagesize);
		return page_list;
	}
	@Override
	public List<BlCompany> getCompanyList(Map<String,String> conditions){
    	String sql = "select com_id,com_name,com_tel,com_addr from bl_company where 1=1 ";
    	if(conditions!=null&&FormatUtil.isEmptyString(conditions.get("com_name"))){
    		sql += " and com_name like CONCAT('%',"+conditions.get("com_name")+",'%')";
    	}
    	return jdbcTemplate.query(sql, new BlCompany());
    }
	@Override
    public PageList<BlCompany> getCompanyPageList(long page,long pageSize,Map<String,String> conditions){
    	PageList<BlCompany> pageList = new PageList<BlCompany>();
    	long start = (page-1)*pageSize;
    	
    	String condition = "";
    	if(conditions!=null&&FormatUtil.isEmptyString(conditions.get("com_name"))){
    		condition += " and com_name like CONCAT('%',"+conditions.get("com_name")+",'%')";
    	}
    	String total_sql = "select count(1) from bl_company where 1=1 "+condition;
    	String page_sql = "select c.com_id,c.com_name,c.com_tel,c.com_addr "
    			+ "from bl_company c where 1=1 "+condition
    			+" and c.com_id>=(select cc.com_id from bl_company cc order by cc.com_id limit "
    			+start+",1) order by c.com_id limit "+pageSize;
    	List<BlCompany> list = jdbcTemplate.query(page_sql, new BlCompany());
    	long total = jdbcTemplate.queryForObject(total_sql,Integer.class);
    	pageList.setList(list);
    	pageList.setCurrs(page);
    	pageList.setPageSize(pageSize);
    	pageList.setTotal(total);
    	return pageList;
    }

}
