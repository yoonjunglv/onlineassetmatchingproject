package com.shinhan.investgoal;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;

public class InvestgoalController implements CommonControllerInterface{

	static Scanner sc = new Scanner(System.in);
	static InvestgoalService investgoalservice = new InvestgoalService();
	private String userid;
	
	public InvestgoalController(String userid) {
		this.userid = userid;
	}

	@Override
	public void execute() {
		int result = investgoalservice.investgoalInsert(makegoal());
		InvestgoalView.display(result+"건의 투자목표가 생성되었습니다.");
	}

	private InvestgoalDTO makegoal() {
		System.out.println("---------- 다음 중 자신의 투자목표를 선택해주세요 ---------");
		System.out.println("은퇴자금 | 교육자금 | 주택자금 | 결혼자금 | 연금설계 | 목돈설계 ");
		System.out.println("------------------------------------------------");
		System.out.print("투자 목표 >> ");
		String goal_type = sc.next();
		System.out.print("목표 금액 >> ");
		int target_amount = sc.nextInt();
		// 투자 목표 날짜
		System.out.print("목표 날짜(yyyy-mm-dd) >> ");
		String target_date = sc.next();
		Date sqlDate = convertToSqlDate(target_date);
		
		// 투자 목표 설정 날짜 (현재 시간)
		java.util.Date currentDate = new java.util.Date();
		Date p_sqlDate = new Date(currentDate.getTime());
		
		InvestgoalDTO investgoal = InvestgoalDTO.builder()
				.user_id(userid)
				.goal_type(goal_type)
				.target_amount(target_amount)
				.target_date(sqlDate)
				.created_goal(p_sqlDate)
				.build();
		return investgoal;
	}
	
	// 날짜 포맷 변경
	public static Date convertToSqlDate(String inputDate) {
        // 입력 날짜 포맷 지정 (예: "yyyy-MM-dd")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // java.util.Date로 파싱
            java.util.Date utilDate = sdf.parse(inputDate);
            // java.sql.Date로 변환
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // 혹은 예외 처리 방식에 따라 throw
        }
    }

}
