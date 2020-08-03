package com.saifullah.stockexchangeservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saifullah.stockexchangeservice.entities.StockExchangeEntity;

@Repository
public interface StockExchangeRepository extends CrudRepository<StockExchangeEntity,Integer>{
	

}
