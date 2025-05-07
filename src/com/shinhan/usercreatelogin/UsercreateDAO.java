package com.shinhan.usercreatelogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shinhan.dbconnect.DBUtill;


public class UsercreateDAO {
	// 유저 삽입
	public int userInsert(UserCreateDTO user) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		String sql = """
				insert into app_user(
				USER_ID,          
				USER_PW,           
				SEX,               
				AGE,               
				EMAIL,             
				PHONE,             
				HOME_ADDRESS,      
				PFINANCIAL_ASSET,  
				PESTATE_INVESTMENT)
				values(?,?,?,?,?,?,?,?,?)
				""";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, user.getUser_id());
			st.setString(2, user.getUser_pw());
			st.setString(3, user.getSex());
			st.setInt(4, user.getAge());
			st.setString(5, user.getEmail());
			st.setString(6, user.getPhone());
			st.setString(7,user.getHome_address());
			st.setInt(8, user.getPfinancial_asset());
			st.setInt(9, user.getPestate_investment());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
