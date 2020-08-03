package com.saifullah.companyservice.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.saifullah.companyservice.dao.CompanyRepository;
import com.saifullah.companyservice.dto.CompanyDTO;
import com.saifullah.companyservice.dto.IpoDTO;
import com.saifullah.companyservice.entities.CompanyEntity;
import com.saifullah.companyservice.ipoclient.IpoClient;
import com.saifullah.companyservice.stockpriceclient.StockPriceClient;

@Service
@EnableTransactionManagement
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepository companyRepository;
	private IpoClient ipoClient;
	private StockPriceClient stockPriceClient;
	
	@Autowired
	public CompanyServiceImpl(CompanyRepository companyRepository, IpoClient ipoClient, StockPriceClient stockPriceClient) {
		this.companyRepository = companyRepository;
		this.ipoClient = ipoClient;
		this.stockPriceClient = stockPriceClient;
	}


    @Override
    @Transactional
	public CompanyDTO addCompany(CompanyDTO companyDTO)
	{
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyEntity companyEntity=mapper.map(companyDTO,CompanyEntity.class);
        companyRepository.save(companyEntity);
		return companyDTO;
	}
    
    
    @Override
    @Transactional 
    public Iterable<Double> getCompanyStockPrice(long companyId, Date from, Date to, int period)
    {
    
    	return stockPriceClient.getCompanyStockPrice(companyId, from, to, period);
    }

    
    @Override
    @Transactional
    public Iterable<CompanyDTO> getMatchingCompanies(String pattern)
    {
    	
    	List<CompanyDTO> list = new ArrayList<>();
    	
    	Iterable<CompanyEntity> companyEntity = companyRepository.findByCompanyNameContaining(pattern);
    	
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        for(CompanyEntity entity: companyEntity)
        {
        	list.add(mapper.map(entity, CompanyDTO.class));
        }
    	
        Iterable<CompanyDTO> companyDTO = list;
        return companyDTO;

    }
    
    
    @Override
    @Transactional    
    public CompanyDTO getCompanyDetails(String companyName)
    {
    	
    	CompanyEntity companyEntity = companyRepository.findByCompanyName(companyName);
    	CompanyDTO companyDTO=null;
    	if(companyEntity!=null)
    	{
            ModelMapper mapper=new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            companyDTO = mapper.map(companyEntity, CompanyDTO.class);
            
    	}
    	return companyDTO;
    }
    
    
    @Override
    @Transactional 
    public IpoDTO getIpoDetails(long companyId)
    {
    	IpoDTO ipoDTOResponse = ipoClient.getIpoDetails(companyId);
    	return ipoDTOResponse;
    }
    
    
    
	@Override
	 @Transactional
	public Iterable<CompanyDTO> getCompanyDetailsBySector(String sector) {
		List<CompanyDTO> list = new ArrayList<>();
	    Iterable<CompanyEntity> companyEntity=companyRepository.findBySector(sector);
	    ModelMapper mapper=new ModelMapper();
	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    
	    for(CompanyEntity entity: companyEntity) {
	    	list.add(mapper.map(entity, CompanyDTO.class));
	    }
	    Iterable<CompanyDTO> companyDTO=list;
	    return companyDTO;
	}

	@Override
	public Iterable<Double> getSectorStockPrice(String sector, Date from, Date to, int period) {
		return null;
	}
	
	public List<CompanyDTO> getCompaniesList(String stockExchange)
	{
		List<CompanyDTO> list = new ArrayList<>();
	    Iterable<CompanyEntity> companyEntity=companyRepository.findByStockExchange(stockExchange);
	    ModelMapper mapper=new ModelMapper();
	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    
	    for(CompanyEntity entity: companyEntity) {
	    	list.add(mapper.map(entity, CompanyDTO.class));
	    }
	    Iterable<CompanyDTO> companyDTO=list;
	    return list;
	}
}
