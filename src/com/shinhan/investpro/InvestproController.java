package com.shinhan.investpro;

import java.sql.Date;
import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;
import com.shinhan.investgoal.InvestgoalView;

public class InvestproController implements CommonControllerInterface{
	
	static Scanner sc = new Scanner(System.in);
	static InvestproService investproservice = new InvestproService();
	private String userid;

	public InvestproController(String userid) {
		this.userid = userid;
	}

	@Override
	public void execute() {
		int result = investproservice.investproInsert(makegoal());
		InvestgoalView.display(result+"건의 투자성향이 생성되었습니다.");
	}

	private InvestproDTO makegoal() {
		System.out.print("투자경험수준(없음, 중간, 풍부) >> ");
		String investment_experience = sc.next();
		System.out.print("위험감수수준(낮음, 보통, 높음) >> ");
		String risk_tolerance = sc.next();
		System.out.print("최종투자성향(안정형, 중립형, 공격형) >> ");
		String risk_profile = sc.next();
		
		// 투자 성향 설정 날짜 (현재 시간)
		java.util.Date currentDate = new java.util.Date();
		Date sqlDate = new Date(currentDate.getTime());
		
		InvestproDTO investpro = InvestproDTO.builder()
				.user_id(userid)
				.investment_experience(investment_experience)
				.risk_tolerance(risk_tolerance)
				.risk_profile(risk_profile)
				.created_pro(sqlDate)
				.build();
		return investpro;
	}

}
