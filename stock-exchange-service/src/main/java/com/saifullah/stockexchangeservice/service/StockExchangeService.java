package com.saifullah.stockexchangeservice.service;

import java.util.List;

import com.saifullah.stockexchangeservice.dto.CompanyDTO;
import com.saifullah.stockexchangeservice.dto.StockExchangeDTO;

public interface StockExchangeService {
	
	public StockExchangeDTO addStockExchange(StockExchangeDTO stockExchangeDTO);
	public Iterable<StockExchangeDTO> getStockExchangesList();
	public List<CompanyDTO> getCompaniesList(String stockExchange);

}
