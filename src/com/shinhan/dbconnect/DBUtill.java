package com.shinhan.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtill {
	
	// Oracle DB 연결을 Utill로 만들었음
	public static Connection getConnection() {
		Connection conn = null;
		// 강사 pc : 192.168.0.18
		// 내 pc : 192.168.0.240
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "amproject", userpass = "2137";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userid, userpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	// DB 연결 시 사용한 자원 해제
	public static void dbDisconnect(
			Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
