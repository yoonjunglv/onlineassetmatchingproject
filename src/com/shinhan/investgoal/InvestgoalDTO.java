package com.shinhan.investgoal;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Data
public class InvestgoalDTO {    
	private String user_id;      
	private String goal_type;    
	private Integer target_amount;
	private Date target_date;  
	private Date created_goal; 
}
