package com.shinhan.investpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shinhan.dbconnect.DBUtill;

public class InvestproDAO {

	// 투자 성향 생성
	public int investproInsert(InvestproDTO investpro) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		String sql = """
				insert into user_investmentprofile(
				USER_ID,              
				INVESTMENT_EXPERIENCE,
				RISK_TOLERANCE,       
				RISK_PROFILE,         
				CREATED_PRO)
				values(?,?,?,?,?)          
				""";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, investpro.getUser_id());
			st.setString(2, investpro.getInvestment_experience());
			st.setString(3, investpro.getRisk_tolerance());
			st.setString(4, investpro.getRisk_profile());
			st.setDate(5, investpro.getCreated_pro());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
