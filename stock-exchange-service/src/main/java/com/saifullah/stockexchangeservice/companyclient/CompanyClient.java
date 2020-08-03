package com.saifullah.stockexchangeservice.companyclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saifullah.stockexchangeservice.dto.CompanyDTO;

@FeignClient("company-service")
public interface CompanyClient {
	
	@GetMapping(value= "/stockExchange/{stockExchange}")
	public List<CompanyDTO> getCompaniesList(@PathVariable String stockExchange);

}
