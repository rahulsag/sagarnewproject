package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.UserDetailBean;

@Repository
public class UserDeatilDao {

	@Autowired
	JdbcTemplate DBCon;
	
	public int of_insert_data(UserDetailBean user_detailBean)
	{
		int ll_ret;
		
		String ls_query="INSERT INTO USER_DETAILS(USER_NAME, USER_PASSWORD, FIRST_NAME, LAST_NAME, USER_ADDRESS, USER_MOBILE) "
				+ "VALUES('"+user_detailBean.getLs_username()+"','"+user_detailBean.getLs_userpassword()+"',"
						+ "'"+user_detailBean.getLs_first_name()+"','"+user_detailBean.getLs_last_name()+"',"
						+"'"+user_detailBean.getLs_address()+"','"+user_detailBean.getLi_mobile()+"')";
	
		ll_ret=DBCon.update(ls_query);
		if(ll_ret > 0)
		{
			System.out.println(ll_ret+" row inserted.");
		}
		
		return ll_ret;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<UserDetailBean> of_get_user_detail()
	{
		//return (ArrayList<UserDetailBean>) DBCon.query("SELECT * FROM USER_DETAILS",new BeanPropertyRowMapper<UserDetailBean>(UserDetailBean.class));	
		
		  return (ArrayList<UserDetailBean>)DBCon.query("SELECT * FROM USER_DETAILS", new UserAllData());				 
	}
	
	public int of_delete_data(String ls_user_nm)
	{
		int ll_ret;
		String ls_query="DELETE FROM USER_DETAILS WHERE USER_NAME='"+ls_user_nm+"'";
		ll_ret=DBCon.update(ls_query);
		System.out.println("deleted data:-"+ll_ret);
		return ll_ret;
		
	}
}

class UserAllData implements RowMapper {

	@Override
	public UserDetailBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{ 
		UserDetailBean user_bean=new UserDetailBean(); 
		user_bean.setLs_first_name(rs.getString("FIRST_NAME"));
		user_bean.setLs_last_name(rs.getString("LAST_NAME"));
		user_bean.setLs_username(rs.getString("USER_NAME"));
		user_bean.setLs_userpassword(rs.getString("USER_PASSWORD"));
		user_bean.setLs_address(rs.getString("USER_ADDRESS"));
		user_bean.setLi_mobile(rs.getInt("USER_MOBILE")); 
		System.out.println("object data::"+user_bean.toString());
		return user_bean;
	}

}
