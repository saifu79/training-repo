package com.saifullah.companyservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//point cut
@ControllerAdvice
public class CompanyControllerExceptionHandler {

    //hookup method
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(CompanyNotFoundException exc)
    {
        ErrorResponse errorResponse=new ErrorResponse(exc.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
   /* @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserNotFoundException1(UserNotFoundException exc)
    {
        ErrorResponse errorResponse=new ErrorResponse("i am in 2nd", HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }*/
}
