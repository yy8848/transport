package com.pjtc.transport.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.CredentialInvalidException;
import com.pjtc.transport.UserNotFoundException;
import com.pjtc.transport.ValidationException;
import com.pjtc.transport.web.Message;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public void handleConflict() {
        // Nothing to do
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserNotFoundException.class, CredentialInvalidException.class})
    @ResponseBody Message handleBadRequest(HttpServletRequest req, Exception ex) {
    	
        return new Message(Message.MESSAGE_TYPE_ERROR, 
        		((ExceptionBase)ex).getLocalizedMessage(req.getLocale()));
    }
    
    
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ExceptionBase.class})
    @ResponseBody Message handleInternalServerError(HttpServletRequest req, Exception ex) {
    	
        return new Message(Message.MESSAGE_TYPE_ERROR, 
        		((ExceptionBase)ex).getLocalizedMessage(req.getLocale()));
    } 
}