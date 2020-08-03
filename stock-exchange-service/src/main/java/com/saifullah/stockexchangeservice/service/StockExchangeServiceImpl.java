package com.saifullah.stockexchangeservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.saifullah.stockexchangeservice.companyclient.CompanyClient;
import com.saifullah.stockexchangeservice.dao.StockExchangeRepository;
import com.saifullah.stockexchangeservice.dto.CompanyDTO;
import com.saifullah.stockexchangeservice.dto.StockExchangeDTO;
import com.saifullah.stockexchangeservice.entities.StockExchangeEntity;

@Service
@EnableTransactionManagement
public class StockExchangeServiceImpl implements StockExchangeService{

	@Autowired
	private StockExchangeRepository stockExchangeRepository;
	@Autowired
	private CompanyClient companyClient;
	
	 @Override
    @Transactional
	public StockExchangeDTO addStockExchange(StockExchangeDTO stockExchangeDTO)
	{
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StockExchangeEntity stockExchangeEntity=mapper.map(stockExchangeDTO,StockExchangeEntity.class);
        stockExchangeRepository.save(stockExchangeEntity);
		return stockExchangeDTO;
	}
	
	@Override
	@Transactional
	public Iterable<StockExchangeDTO> getStockExchangesList()
	{
		List<StockExchangeDTO> list = new ArrayList<>();
	    Iterable<StockExchangeEntity> stockExchangeEntity= stockExchangeRepository.findAll();
	    ModelMapper mapper=new ModelMapper();
	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    
	    for(StockExchangeEntity entity:stockExchangeEntity) {
	    	list.add(mapper.map(entity, StockExchangeDTO.class));
	    }
	    Iterable<StockExchangeDTO> stockExchangeDTO = list;
	    return stockExchangeDTO;
	}
	
	@Override
	@Transactional
	public List<CompanyDTO> getCompaniesList(String stockExchange)
	{
		return companyClient.getCompaniesList(stockExchange);
		
	}
	
}
