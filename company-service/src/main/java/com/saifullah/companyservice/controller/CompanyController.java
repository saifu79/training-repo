package com.saifullah.companyservice.controller;

import java.sql.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saifullah.companyservice.dto.CompanyDTO;
import com.saifullah.companyservice.dto.IpoDTO;
import com.saifullah.companyservice.entities.CompanyEntity;
import com.saifullah.companyservice.exceptions.CompanyNotFoundException;
import com.saifullah.companyservice.service.CompanyService;

@RestController
//@RequestMapping("company")
public class CompanyController {
	private CompanyService companyService;
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	
	@PostMapping("/")
    public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDetails)
    {
        CompanyDTO companyDTO = companyService.addCompany(companyDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyDTO);
    }
	

	@RequestMapping(value="/getCompanyStockPrice/{companyId}/{from}/{ to}/{period}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Iterable<Double>> getCompanyStockPrice(@PathVariable long companyId, @PathVariable  Date from, @PathVariable  Date to, @PathVariable  int period) {
		return ResponseEntity.status(HttpStatus.OK).body( companyService.getCompanyStockPrice(companyId, from, to, period));
	}
    
	
    @GetMapping("/getMatchingCompanies/{pattern}")
    public  ResponseEntity<Iterable<CompanyDTO>> getMatchingCompanies(@PathVariable("pattern") String pattern) throws CompanyNotFoundException {
    	
    	Iterable<CompanyDTO> companyDTO = companyService.getMatchingCompanies(pattern);
    	

        if(companyDTO==null)
        {
            throw new CompanyNotFoundException("No Company found with the pattern: "+pattern);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(companyDTO);
    }
    
    
    @GetMapping("/getCompanyDetails/{companyName}")
    public  ResponseEntity<CompanyDTO> getCompanyDetails(@PathVariable("companyName") String companyName) throws CompanyNotFoundException {
        CompanyDTO companyDTO= companyService.getCompanyDetails(companyName);

        if(companyDTO==null)
        {
            throw new CompanyNotFoundException("Company not found with the Company Name: "+companyName);
        }
                
        return ResponseEntity.status(HttpStatus.FOUND).body(companyDTO);
    }
    
    
    @RequestMapping(value = "/getIpoDetails/{companyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public IpoDTO getIpoDetails(@PathVariable long companyId) {
        return companyService.getIpoDetails(companyId);
    }
    
    
	@RequestMapping(value="/sector/{sector}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<CompanyDTO>> getCompanyDetailsBySector(@PathVariable (name = "sector") String sector){
		return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getCompanyDetailsBySector(sector));
	}
	
	/*@RequestMapping(value="/{sector}/{from}/{ to}/{period}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Iterable<Double>> getSectorPrice(@PathVariable String sector, @PathVariable Date from, @PathVariable  Date to, @PathVariable  int period) {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(companyService.getSectorStockPrice(sector, from, to, period));
		
		
	}*/
	@GetMapping("/stockExchange/{stockExchange}")
	public ResponseEntity<List<CompanyDTO>> getCompaniesList(@PathVariable String stockExchange)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getCompaniesList(stockExchange));
	}
    
}
