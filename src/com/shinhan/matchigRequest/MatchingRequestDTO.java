package com.shinhan.matchigRequest;

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
public class MatchingRequestDTO {
	private String user_id;   
	private String goal_type; 
	private Date request_at;
}
