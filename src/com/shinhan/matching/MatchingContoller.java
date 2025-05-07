package com.shinhan.matching;

import java.util.List;

import com.shinhan.common.CommonControllerInterface;

public class MatchingContoller implements CommonControllerInterface{
	
	static MatchingService matchingservice = new MatchingService();
	static String userid;
	
	public MatchingContoller(String userid) {
		this.userid = userid;
	}

	@Override
	public void execute() {
		List<MatchingDTO> matchinglist = matchingservice.selectById(userid);
		MatchingView.display(matchinglist);
	}
	

}
