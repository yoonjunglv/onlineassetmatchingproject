package com.shinhan.matching;

import java.util.List;

public class MatchingView {
	
	public static void display(String message) {
		System.out.println("알림: " + message);
	}
	
	public static void display(List<MatchingDTO> matchinglist) {
		if (matchinglist.size() == 0) {
			display("========== 진행 중인 매칭이 없습니다. ==========");
			return;
		}
		System.out.println("********** 전문가 1:1 매칭 진행중 **********");
		matchinglist.stream().forEach(matching->System.out.println(matching));
	}
}
