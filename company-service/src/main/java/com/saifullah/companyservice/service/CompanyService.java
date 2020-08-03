package com.saifullah.companyservice.service;

import java.sql.Date;
import java.util.List;

import com.saifullah.companyservice.dto.CompanyDTO;
import com.saifullah.companyservice.dto.IpoDTO;

public interface CompanyService {

	public CompanyDTO addCompany(CompanyDTO companyDTO);
	
	public Iterable<Double> getCompanyStockPrice(long companyId, Date from, Date to, int period);
	public Iterable<CompanyDTO> getMatchingCompanies(String pattern);
	public CompanyDTO getCompanyDetails(String companyName);
	public IpoDTO getIpoDetails(long companyId);
	
	public Iterable<CompanyDTO> getCompanyDetailsBySector(String sector);
	public Iterable<Double> getSectorStockPrice(String sector, Date from, Date to, int period);
	
	public List<CompanyDTO> getCompaniesList(String stockExchange);
}
