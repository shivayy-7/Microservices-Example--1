package com.marketing_db_1.services;

import java.util.List;

import com.marketing_db_1.entities.Lead;

public interface LeadService {
	public void saveLead(Lead lead);

	public List<Lead> getLeads();

	public void deleteLead(long id);

	public Lead findOneLead(long id);

	

}
