package com.saifullah.companyservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saifullah.companyservice.entities.CompanyEntity;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity,Integer> {

	public CompanyEntity findByCompanyName(String companyName);
	
	//@Query(value = "SELECT * FROM Company  WHERE   companyName LIKE '%?1%' " , nativeQuery = true)
	public Iterable<CompanyEntity> findByCompanyNameContaining(String pattern);
	
	public Iterable<CompanyEntity> findBySector(String sector);
	
	public Iterable<CompanyEntity> findByStockExchange(String stockExchange);
}
