package com.saifullah.companyservice.exceptions;

import lombok.Getter;

@Getter
public class CompanyNotFoundException extends Throwable {
    private String message;
    public CompanyNotFoundException() {
    }
    public CompanyNotFoundException(String s) {
        this.message=s;
    }

}
