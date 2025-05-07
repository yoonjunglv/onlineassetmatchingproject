package com.shinhan.account;

import java.util.List;

import com.shinhan.common.CommonControllerInterface;

public class AccountselectController implements CommonControllerInterface{
	
	static AccountService accountservice = new AccountService();
	private String userid;
	
	public AccountselectController(String userid) {
		this.userid = userid;
	}

	@Override
	public void execute() {
		List<AccountDTO> accountlist = accountservice.selectById(userid);
		AccountView.display(accountlist);
	}
	
}
