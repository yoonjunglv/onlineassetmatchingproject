package com.shinhan.account;

import java.util.List;

public class AccountView {
	public static void display(String message) {
		System.out.println("*** 메시지 *** "+message);
	}
	
	public static void display(List<AccountDTO> accountlist) {
		if (accountlist.size() == 0) {
			display("계좌가 존재하지 않습니다.");
			return;
		}
		System.out.println("========== 나의 계좌 조회 ==========");
		accountlist.stream().forEach(account->System.out.println(account));
	}
}
