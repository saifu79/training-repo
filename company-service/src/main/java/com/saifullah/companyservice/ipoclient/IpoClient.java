package com.saifullah.companyservice.ipoclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saifullah.companyservice.dto.IpoDTO;

@FeignClient("ipo-service")
public interface IpoClient {
	
	@GetMapping(value= "/ipoDetails/{companyId}")
	public IpoDTO getIpoDetails(@PathVariable(name= "companyId") long companyId);

}