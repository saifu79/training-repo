package com.saifullah.companyservice.stockpriceclient;

import java.sql.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("stock-price-service")
public interface StockPriceClient {
	
	@GetMapping(value= "/getCompanyStockPrice/{companyId}/{from}/{to}/{period}")
	public  Iterable<Double> getCompanyStockPrice(@PathVariable(name= "companyId") long companyId, @PathVariable(name= "from")  Date from, @PathVariable(name= "to")  Date to, @PathVariable(name= "period")  int period);

}