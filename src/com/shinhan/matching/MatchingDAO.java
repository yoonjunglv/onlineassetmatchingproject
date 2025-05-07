package com.shinhan.matching;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbconnect.DBUtill;

public class MatchingDAO {
	
	// 매칭 삭제시 
	public int matchingDeleteById(String userid, String goal_type) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		String sql = "delete from matching where user_id = ? and goal_type = ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			st.setString(2, goal_type);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<MatchingDTO> selectById(String userid) {
		List<MatchingDTO> matchinglist = new ArrayList<>();;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "select * from matching where user_id = ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			rs = st.executeQuery();
			while(rs.next()) {
				MatchingDTO matching = MatchingDTO.builder()
						.matching_id(rs.getInt("matching_id"))
						.user_id(rs.getString("user_id"))
						.expert_id(rs.getString("expert_id"))
						.goal_type(rs.getString("goal_type"))
						.matched_at(rs.getDate("matched_at"))
						.build();
				matchinglist.add(matching);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, rs);
		}
		
		return matchinglist;
	}

}
