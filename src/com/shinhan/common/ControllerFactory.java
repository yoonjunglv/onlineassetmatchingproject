package com.shinhan.common;

import com.shinhan.usercreatelogin.UsercreateController;
import com.shinhan.expert.ExpertController;
import com.shinhan.login.LoginController;

public class ControllerFactory {
	
	public static CommonControllerInterface make(String business) {
		CommonControllerInterface controller = null;
		
		switch(business) {
		case "usercreate" -> {controller = new UsercreateController();}
		case "login" -> {controller = new LoginController();}
		case "expert" -> {controller = new ExpertController();}
		}
		return controller;
	}
}
