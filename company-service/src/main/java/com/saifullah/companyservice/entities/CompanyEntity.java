package com.saifullah.companyservice.entities;

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
@Table(name="Company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long companyId;
    
    private String companyName;
    private Double turnover;
    private String ceo;
    private String directors;
    private String stockExchange;
    private String sector;
    private String brief;
    private long companyStockCode;
    
}
