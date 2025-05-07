package com.shinhan.usercreatelogin;

public class UsercreateService {
	
	UsercreateDAO usercreateDAO = new UsercreateDAO();
	
	public int userInsert(UserCreateDTO user) {
		return usercreateDAO.userInsert(user);
	}
}
