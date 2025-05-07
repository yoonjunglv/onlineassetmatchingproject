package com.shinhan.usercreatelogin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
@Data
public class UserCreateDTO {
	private String user_id;           
	private String user_pw;           
	private String sex;               
	private Integer age;               
	private String email;             
	private String phone;             
	private String home_address;      
	private Integer pfinancial_asset;  
	private Integer pestate_investment;
}
