package com.bl.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bl.bean.BlUser;
import com.bl.dao.UserDao;
@Repository("UserDao")
public class UserDaoImp implements UserDao {

	@Autowired
    private transient JdbcTemplate jdbcTemplate;
	
    public BlUser getUserByKey(BlUser user) {
        String sql = "select user_id,user_name,user_password from bl_user where user_name=? and user_password=password(?)";
        List<BlUser> list = jdbcTemplate.query(sql, 
        		new RowMapper<BlUser>(){
					@Override
					public BlUser mapRow(ResultSet rs, int arg1)
							throws SQLException {
						BlUser blUser = new BlUser();
						blUser.setUser_name(rs.getString("user_name"));
						blUser.setUser_id(rs.getString("user_id"));
						blUser.setUser_password(rs.getString("user_password"));
						return blUser;
					}
        		}, user.getUser_name(), user.getUser_password());
        if(null != list && list.size() > 0)
        	return list.get(0);
        return null;
    }  
    
}
