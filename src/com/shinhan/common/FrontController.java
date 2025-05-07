package com.shinhan.common;

import java.util.Scanner;

public class FrontController {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		CommonControllerInterface controller = null;
		
		while(!isStop) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.회원가입  ||  2.로그인  ||  3.전문가등록  ||  4.종료  ");
			System.out.println("-----------------------------------------------");
			System.out.print("작업 선택 >> ");
			int job = sc.nextInt();
			
			switch(job) {
			case 1 ->{controller = ControllerFactory.make("usercreate");}
			case 2 ->{controller = ControllerFactory.make("login");}
			case 3 ->{controller = ControllerFactory.make("expert");}
			case 4 ->{isStop = true; continue;}
			default ->{continue;}
			}
			// 전략 패턴
			controller.execute(); // 작업이 달라져도 사용법은 같다. (전략 패턴)
		}
		sc.close();
		System.out.println("========== 서비스가 종료되었습니다. ==========");
	}
}
