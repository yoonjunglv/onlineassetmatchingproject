package com.shinhan.expert;

import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;

public class ExpertController implements CommonControllerInterface{

	static Scanner sc = new Scanner(System.in);
	static ExpertService expertservice = new ExpertService();
	
	@Override
	public void execute() {
		int result = expertservice.expertInsert(makeExpert());
		ExpertView.display(result+"명의 전문가가 생성되었습니다.");
	}

	private ExpertDTO makeExpert() {
		System.out.print("아이디 >> ");
		String expert_id = sc.next();
		System.out.print("이름 >> ");
		String name = sc.next();
		System.out.print("최대 매칭 유지 갯수 >> ");
	    int match_maximum = sc.nextInt();
	    System.out.println("--다음 전문분야 중 자신있는 분야를 순서대로 3건 선택해 주세요.--");
	    System.out.println("은퇴자금 | 교육자금 | 주택자금 | 결혼자금 | 연금설계 | 목돈설계 ");
	    System.out.println("-------------------------------------------------");
	    System.out.print("전문분야 >> ");
	    String specialty = sc.next();
	    System.out.println("-다음 매칭성향 중 자신의 투자성향을 골라주세요-");
	    System.out.println("   안정형   |    중립형    |   공격형   ");
	    System.out.println("----------------------------------");
	    System.out.print("메칭 성향 >> ");
	    String risk_profile = sc.next();
	    System.out.print("경력(년차) >> ");
	    int experience_years = sc.nextInt();
	    int p_count = 0;
	    int averagerscore = 0;
	    
	    ExpertDTO expert = ExpertDTO.builder()
	    		.expert_id(expert_id)
	    		.name(name)
	    		.match_maximum(match_maximum)
	    		.p_count(p_count)
	    		.specialty(specialty)
	    		.risk_profile(risk_profile)
	    		.experience_years(experience_years)
	    		.averagerscore(averagerscore)
	    		.build();
		return expert;
	}

}
