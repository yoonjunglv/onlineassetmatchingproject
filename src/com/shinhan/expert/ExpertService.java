package com.shinhan.expert;

public class ExpertService {

	ExpertDAO expertDAO = new ExpertDAO();
	
	public int expertInsert(ExpertDTO expert) {
		return expertDAO.expertInsert(expert);
	}

}
