package com.shinhan.expert;

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
public class ExpertDTO {
	private String expert_id;       
	private String name;            
	private Integer match_maximum;
	private Integer p_count;
	private String specialty;          
	private String risk_profile;    
	private Integer experience_years;
	private Integer averagerscore;   
}
