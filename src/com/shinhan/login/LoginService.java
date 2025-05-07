package com.shinhan.login;

public class LoginService {
	
	LoginDAO loginDAO = new LoginDAO();
	
	public LoginDTO selectById(String userid, String userpw) {
		return loginDAO.selectById(userid, userpw);
	}
}
