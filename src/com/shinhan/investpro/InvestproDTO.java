package com.shinhan.investpro;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.StandardException;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Data
public class InvestproDTO {
	private String user_id;              
	private String investment_experience;
	private String risk_tolerance;       
	private String risk_profile;         
	private Date created_pro;          
}
