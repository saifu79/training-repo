package com.saifullah.companyservice.dto;

import lombok.Data;

/**
 * POJO for holding Order related data
 */
@Data
public class IpoDTO {

    private long companyId;
    
	private String companyName;

    private String stockExchange;

    private float pricePerShare;

    private int totalShares;
    
    private String openDateTime;
}
