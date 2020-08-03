package com.saifullah.stockexchangeservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockExchangeDTO {
	
	private String stockExchange;
	private String stockExchangeBrief;
	private String stockExchangeContactAddress;
	private String stockExchangeRemark;

}
