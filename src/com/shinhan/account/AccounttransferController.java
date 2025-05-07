package com.shinhan.account;

import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;

public class AccounttransferController implements CommonControllerInterface{

	static Scanner sc = new Scanner(System.in);
	static AccountService accountservice = new AccountService();
	private String userid;
	
	public AccounttransferController(String userid) {
		this.userid = userid; 
	}

	@Override
	public void execute() {
		System.out.print("송금할 계좌번호>> ");
		int account_number = sc.nextInt();
		System.out.print("이체할 금액>> ");
		int balance = sc.nextInt();
		int result = accountservice.updatebalance(account_number, balance);
        if(result > 0) {
            AccountView.display("========== 계좌이체 성공 ==========");
        } else {
            AccountView.display("========== 계좌가 존재하지 않습니다 ==========");
        }

	}

}
