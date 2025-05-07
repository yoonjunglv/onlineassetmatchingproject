package com.shinhan.investgoal;

public class InvestgoalService {
	
	InvestgoalDAO investgoalDAO = new InvestgoalDAO();
	
	public int investgoalInsert(InvestgoalDTO investgoal) {
		return investgoalDAO.investgoalInsert(investgoal);
	}
}
