package com.shinhan.account;

import java.sql.Date;
import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;
public class AccountController implements CommonControllerInterface{
	
	static Scanner sc = new Scanner(System.in);
	static AccountService accountservice = new AccountService();
	private String userid;
	
	public AccountController(String userid) {
		this.userid = userid;
	}

	@Override
	public void execute() {
		int result = accountservice.accountInsert(makeAccount());
		AccountView.display(result+"건의 계좌가 생성되었습니다.");
	}

	private AccountDTO makeAccount() {
		System.out.print("계좌 비밀번호 입력 >> ");
		String account_pw = sc.next();
		System.out.print("입금하시겠습니까? (금액 or 0) >> ");
		int current_balance = sc.nextInt();
		
		// 현재 날짜를 java.util.Date로 얻기
        java.util.Date currentDate = new java.util.Date();

        // java.util.Date를 java.sql.Date로 변환
        Date sqlDate = new Date(currentDate.getTime());
		
		AccountDTO account = AccountDTO.builder()
				.user_id(userid)
				.account_pw(account_pw)
				.current_balance(current_balance)
				.created_at(sqlDate)
				.build();
		return account;
	}
	
}
