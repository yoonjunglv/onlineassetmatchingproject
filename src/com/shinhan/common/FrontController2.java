package com.shinhan.common;

import java.util.Scanner;

public class FrontController2 {
	
	public static void main(String userid) {
		
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		CommonControllerInterface controller = null;
		
		while(!isStop) {
			System.out.println("------------------- MENU ----------------------");
			System.out.println("1.증권 계좌발급  ||  2.증권 계좌조회  ||  3.증권 계좌이체  ");
			System.out.println("4.투자성향 등록  ||  5.투자목표 등록  ||  6.전문가매칭신청  ");
			System.out.println("7.매칭결과 확인  ||  8.매칭종료 신청  ||  9.로그아웃 하기  ");
			System.out.println("-----------------------------------------------");
			System.out.print("작업 선택 >> ");
			int job = sc.nextInt();
			
			switch(job) {
			case 1 -> {controller = ControllerFactory2.make("accountcreate", userid);}
			case 2 -> {controller = ControllerFactory2.make("accountsearch", userid);}
			case 3 -> {controller = ControllerFactory2.make("accounttransfer", userid);}
			case 4 -> {controller = ControllerFactory2.make("investprofile", userid);}
			case 5 -> {controller = ControllerFactory2.make("investgoal", userid);}
			case 6 -> {controller = ControllerFactory2.make("matchingrequest", userid);}
			case 7 -> {controller = ControllerFactory2.make("matchingresult", userid);}
			case 8 -> {controller = ControllerFactory2.make("matchingend", userid);}
			case 9 -> {isStop = true; continue;}
			default -> {continue;}
			}
			// 전략 패턴
			controller.execute();
		}
		System.out.println("========== 로그아웃 되었습니다. ==========");
	}
}

