package com.shinhan.matching;

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
public class MatchingDTO {
	private int matching_id;
	private String user_id;    
	private String expert_id;
	private String goal_type;
	private Date matched_at; 
}
