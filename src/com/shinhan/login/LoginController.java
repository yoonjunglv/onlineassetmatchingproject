package com.shinhan.login;

import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;
import com.shinhan.common.FrontController2;

public class LoginController implements CommonControllerInterface{
	
	static Scanner sc = new Scanner(System.in);
	static LoginService loginService = new LoginService();
	
	@Override
	public void execute() {
		System.out.print("아이디 >> ");
		String user_id = sc.next();
		System.out.print("비밀번호 >> ");
		String user_pw = sc.next();
		
		LoginDTO login = loginService.selectById(user_id, user_pw);
		LoginView.display(login);
		if (login != null) {
			FrontController2.main(user_id);
		}
	}
	

}
