package com.shinhan.matchigRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.shinhan.dbconnect.DBUtill;

public class MatchingRequestDAO {
    
    // 매칭 데이터 삽입
    public int matchingRequest(MatchingRequestDTO matchingrequest) {
        int result = 0;
        Connection conn = DBUtill.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        
        // 1. 동일한 user_id와 goal_type에 대해 매칭이 이미 진행 중인지를 확인
        String checkMatchingSql = "SELECT COUNT(*) FROM matching WHERE user_id = ? AND goal_type = ?";
        
        try {
            st = conn.prepareStatement(checkMatchingSql);
            st.setString(1, matchingrequest.getUser_id());
            st.setString(2, matchingrequest.getGoal_type());
            rs = st.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                // 이미 매칭이 진행 중이면
                return -1; // 매칭 요청 불가 상태를 나타내는 값
            }
            
            // 2. 매칭 요청이 진행 중이지 않으면, 매칭 요청을 삽입
            String sql = "INSERT INTO matchingRequest (user_id, goal_type, request_at) " +
                         "SELECT ?, ?, ? FROM dual " +
                         "WHERE EXISTS (SELECT 1 FROM investment_goal WHERE user_id = ? AND goal_type = ?) " +
                         "AND EXISTS (SELECT 1 FROM user_investmentProfile WHERE user_id = ?)";
            
            st = conn.prepareStatement(sql);
            st.setString(1, matchingrequest.getUser_id());
            st.setString(2, matchingrequest.getGoal_type());
            st.setDate(3, matchingrequest.getRequest_at());
            st.setString(4, matchingrequest.getUser_id());   // for EXISTS in investment_goal
            st.setString(5, matchingrequest.getGoal_type()); // for EXISTS in investment_goal
            st.setString(6, matchingrequest.getUser_id());   // for EXISTS in user_investmentProfile
            
            // SQL 실행
            result = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 정리
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
}
