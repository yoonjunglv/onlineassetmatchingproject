package com.shinhan.matching;

import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;

public class MatchingendController implements CommonControllerInterface{

	static Scanner sc = new Scanner(System.in);
	static MatchingService matchingservice = new MatchingService();
	static String userid;
	
	public MatchingendController(String userid) {
		this.userid = userid;
	}

	@Override
	public void execute() {
		System.out.print("삭제할 투자목표 선택 >> ");
		String goal_type = sc.next();
		int result = matchingservice.matchingDeleteById(userid, goal_type);
		MatchingView.display(result+"건의 매칭을 삭제하였습니다.");
	}

}
