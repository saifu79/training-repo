package com.saifullah.stockexchangeservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "StockExchange")
public class StockExchangeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Stock_Exchange_ID")
    private Long stockExchangeId;
	
    @Column(name = "Stock_Exchange")
    private String stockExchange;
    
    @Column(name = "Stock_Exchange_Brief")
    private String stockExchangeBrief;
    
    @Column(name = "Stock_Exchange_Address")
    private String stockExchangeContactAddress;
    
    @Column(name = "Stock_Exchange_Remark")
    private String stockExchangeRemark;

}
