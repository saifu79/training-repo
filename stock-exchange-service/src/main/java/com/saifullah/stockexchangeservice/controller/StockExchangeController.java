package com.saifullah.stockexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saifullah.stockexchangeservice.dto.CompanyDTO;
import com.saifullah.stockexchangeservice.dto.StockExchangeDTO;
import com.saifullah.stockexchangeservice.service.StockExchangeService;

@RestController
public class StockExchangeController {

	@Autowired
	private StockExchangeService stockExchangeService;
	
	@PostMapping("/stockExchange")
	public  ResponseEntity<StockExchangeDTO> addStockExchange(@RequestBody StockExchangeDTO stockExchangeDTO)
	{
		//System.out.println(stockExchangeDTO.getStockExchange());
		return ResponseEntity.status(HttpStatus.CREATED).body(stockExchangeService.addStockExchange(stockExchangeDTO));
	}
	
	@GetMapping(value= "/stockExchange")
	public ResponseEntity<Iterable<StockExchangeDTO>> getStockExchangesList()
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(stockExchangeService.getStockExchangesList());
	}
	
	@GetMapping(value= "/stockExchange/{stockExchange}")
	public ResponseEntity<Iterable<CompanyDTO>> getCompaniesList(@PathVariable (name = "stockExchange") String stockExchange)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(stockExchangeService.getCompaniesList(stockExchange));
	}
}
