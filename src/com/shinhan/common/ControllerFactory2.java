package com.shinhan.common;

import com.shinhan.account.AccountController;
import com.shinhan.account.AccountselectController;
import com.shinhan.account.AccounttransferController;
import com.shinhan.investgoal.InvestgoalController;
import com.shinhan.investpro.InvestproController;
import com.shinhan.matchigRequest.MatchingRequestController;
import com.shinhan.matching.MatchingContoller;
import com.shinhan.matching.MatchingendController;

public class ControllerFactory2 {
	
	public static CommonControllerInterface make(String business, String userid) {
		CommonControllerInterface controller = null;
		
		switch(business) {
		case "accountcreate"->{controller = new AccountController(userid);}
		case "accountsearch"->{controller = new AccountselectController(userid);}
		case "accounttransfer"->{controller = new AccounttransferController(userid);}
		case "investprofile"->{controller = new InvestproController(userid);}
		case "investgoal"->{controller = new InvestgoalController(userid);}
		case "matchingrequest"->{controller = new MatchingRequestController(userid);}
		case "matchingresult"->{controller = new MatchingContoller(userid);}
		case "matchingend"->{controller = new MatchingendController(userid);}
		}
		return controller;
	}
}
