package com.shinhan.login;

public class LoginView {
	
	public static void display(LoginDTO login) {
		if (login == null) {
			display("회원가입 후 서비스를 이용해 주세요!^^!");
			return;
		}
		System.out.println("환영합니다 :) "+login);
	}
	
	public static void display(String message) {
		System.out.println("*** 메시지 *** "+message);
	}
}
