package com.shinhan.matchigRequest;

import java.sql.Date;
import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;

public class MatchingRequestController implements CommonControllerInterface{
	
	static Scanner sc = new Scanner(System.in);
	static MatchingRequestService matchingRequestservice = new MatchingRequestService();
	static String userid;
	
	public MatchingRequestController(String userid) {
		this.userid = userid;
	}

	@Override
	public void execute() {
		int result = matchingRequestservice.matchingRequest(makemr());
		
		// 결과 처리
		if (result > 0) {
			MatchingRequestView.display(result+"건의 매칭이 신청되었습니다.");
		} else if (result == -1) {
			MatchingRequestView.display("이미 동일한 목표로 매칭이 진행 중입니다. 다른 목표를 선택해 주세요.");
		} else {
			MatchingRequestView.display("4번에서 투자 성향을 먼저 등록해주시고,\n"
					+ "5번에서 요청하는 투자 목표와 동일한 투자 목표를 설정해 주세요!! 그럼 전문가 1:1 매칭 요청이 가능합니다^^");
		}
	}

	private MatchingRequestDTO makemr() {
		System.out.println("*** 요청하는 투자 목표를 선택해 주세요. (주의!: 5번에서 동일한 투자목표를 먼저 등록해야 합니다.) ***");
		System.out.println("은퇴자금 | 교육자금 | 주택자금 | 결혼자금 | 연금설계 | 목돈설계 ");
		System.out.println("------------------------------------------------");
		System.out.print("요청하는 투자 목표 >> ");
		String goal_type = sc.next();
		
		// 매칭 요청 날짜 (현재 시간)
		java.util.Date currentDate = new java.util.Date();
		Date sqlDate = new Date(currentDate.getTime());
		
		MatchingRequestDTO matchingr = MatchingRequestDTO.builder()
				.user_id(userid)
				.goal_type(goal_type)
				.request_at(sqlDate)
				.build();
		return matchingr;
	}
	
}
