package com.shinhan.matching;

import java.util.List;

public class MatchingService {

	MatchingDAO matchingDAO = new MatchingDAO();
	
	public List<MatchingDTO> selectById(String userid) {
		return matchingDAO.selectById(userid);
	}

	public int matchingDeleteById(String userid, String goal_type) {
		return matchingDAO.matchingDeleteById(userid, goal_type);
	}

}
