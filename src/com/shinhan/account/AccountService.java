package com.shinhan.account;

import java.util.List;

public class AccountService {
	AccountDAO accountDAO = new AccountDAO();
	
	public int accountInsert(AccountDTO account) {
		return accountDAO.accountInsert(account);
	}
	
	public List<AccountDTO> selectById(String userid) {
		return accountDAO.selectById(userid);
	}
	
	public int updatebalance(int accountnumber, int balance) {
		return accountDAO.updatebalance(accountnumber, balance);
	}
}
