package com.shinhan.expert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shinhan.dbconnect.DBUtill;

public class ExpertDAO {
	
	// 전문가 삽입
	public int expertInsert(ExpertDTO expert) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		String sql = """
				insert into expert(EXPERT_ID, NAME, MATCH_MAXIMUM, P_COUNT, SPECIALTY, RISK_PROFILE, EXPERIENCE_YEARS, AVERAGERSCORE)
				values(?,?,?,?,?,?,?,?) 
				""";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, expert.getExpert_id());
			st.setString(2, expert.getName());
			st.setInt(3, expert.getMatch_maximum());
			st.setInt(4, expert.getP_count());
			st.setString(5, expert.getSpecialty());
			st.setString(6, expert.getRisk_profile());
			st.setInt(7, expert.getExperience_years());
			st.setInt(8, expert.getAveragerscore());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
