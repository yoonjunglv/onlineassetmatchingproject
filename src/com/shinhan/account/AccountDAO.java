package com.shinhan.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbconnect.DBUtill;
import com.shinhan.login.LoginDTO;

public class AccountDAO {
	
	// 계좌 이체
	public int updatebalance(int accountnumber, int balance) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;

		String sql = """
				update account set
				CURRENT_BALANCE = CURRENT_BALANCE + ?
				where ACCOUNT_NUMBER = ?
				""";
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, balance);
			st.setInt(2, accountnumber);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	// 계좌 조회
	public List<AccountDTO> selectById(String userid) {
		List<AccountDTO> accountlist = new ArrayList<>();
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "select * from account where user_id = ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			rs = st.executeQuery();
			while(rs.next()) {
				AccountDTO account = AccountDTO.builder()
						.account_number(rs.getInt("account_number"))
						.user_id(rs.getString("user_id"))
						.account_pw(rs.getString("account_pw"))
						.current_balance(rs.getInt("current_balance"))
						.created_at(rs.getDate("created_at"))
						.build();
				accountlist.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, rs);
		}
		return accountlist;
	}
	
	// 계좌 생성
	public int accountInsert(AccountDTO account) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		String sql = """
				insert into account(USER_ID, ACCOUNT_PW, CURRENT_BALANCE, CREATED_AT)
				values(?,?,?,?) 
				""";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, account.getUser_id());
			st.setString(2, account.getAccount_pw());
			st.setInt(3, account.getCurrent_balance());
			st.setDate(4, account.getCreated_at());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
