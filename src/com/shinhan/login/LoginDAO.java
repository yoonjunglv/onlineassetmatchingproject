package com.shinhan.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shinhan.dbconnect.DBUtill;

public class LoginDAO {
	
	public LoginDTO selectById(String userid, String userpw) {
		LoginDTO user = null;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "select * from app_user where user_id = ? and user_pw = ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			st.setString(2, userpw);
			rs = st.executeQuery();
			if(rs.next()) {
				user = LoginDTO.builder()
						.user_id(rs.getString("user_id"))
						.user_pw(rs.getString("user_pw"))
						.build();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, rs);
		}
		return user;
	}
}
