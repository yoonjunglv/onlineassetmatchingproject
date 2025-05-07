package com.shinhan.usercreatelogin;

import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;

public class UsercreateController implements CommonControllerInterface{
	
	static Scanner sc = new Scanner(System.in);
	static UsercreateService usercreateService = new UsercreateService();
	
	@Override
	public void execute() {
		int result = usercreateService.userInsert(makeUser());
		UsercreateView.display(result+"명의 유저가 생성되었습니다.");
	}
	
	private static UserCreateDTO makeUser() {
		System.out.print("아이디 >> ");
		String user_id = sc.next();
		System.out.print("비밀번호 >> ");
		String user_pw = sc.next();
		System.out.print("성별(남 or 여) >> ");
		String sex = sc.next();
		System.out.print("나이 >> ");
		int age = sc.nextInt();
		System.out.print("email >> ");
		String email = sc.next();
		System.out.print("phone >> ");
		String phone = sc.next();
		System.out.print("집 주소 >> ");
		String home_address = sc.next();
		System.out.print("현재 보유 금융자산 >>");
		int pfinancial_asset = sc.nextInt();
		System.out.print("현재 보유 투자용 부동산자산 >>");
		int pestate_investment = sc.nextInt();
		
		UserCreateDTO user = UserCreateDTO.builder()
				.user_id(user_id)
				.user_pw(user_pw)
				.sex(sex)
				.age(age)
				.email(email)
				.phone(phone)
				.home_address(home_address)
				.pfinancial_asset(pfinancial_asset)
				.pestate_investment(pestate_investment)
				.build();
		return user;
	}
}
