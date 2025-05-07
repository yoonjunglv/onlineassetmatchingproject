package com.shinhan.investpro;

public class InvestproService {
	
	InvestproDAO investproDAO = new InvestproDAO();
	
	public int investproInsert(InvestproDTO investpro) {
		return investproDAO.investproInsert(investpro);
	}
}
