package com.shinhan.account;

import java.sql.Date;

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
public class AccountDTO {
	private int account_number;
	private String user_id;       
	private String account_pw;     
	private int current_balance;
	private Date created_at;
}
