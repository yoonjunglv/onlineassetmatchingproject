package com.shinhan.matchigRequest;

public class MatchingRequestService {
	
	MatchingRequestDAO matchingrequestDAO = new MatchingRequestDAO();
	
	public int matchingRequest(MatchingRequestDTO matchingrequest) {
		return matchingrequestDAO.matchingRequest(matchingrequest);
	}
}
