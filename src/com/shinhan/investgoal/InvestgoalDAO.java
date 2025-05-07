package com.shinhan.investgoal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shinhan.dbconnect.DBUtill;

public class InvestgoalDAO {
	
	// 투자 목표 생성
	public int investgoalInsert(InvestgoalDTO investgoal) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		String sql = """
				insert into investment_goal(
				USER_ID,      
				GOAL_TYPE,    
				TARGET_AMOUNT,
				TARGET_DATE,  
				CREATED_GOAL)
				values(?,?,?,?,?) 
				""";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, investgoal.getUser_id());
			st.setString(2, investgoal.getGoal_type());
			st.setInt(3, investgoal.getTarget_amount());
			st.setDate(4, investgoal.getTarget_date());
			st.setDate(5, investgoal.getCreated_goal());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
}
