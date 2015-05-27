package com.pjtc.transport.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.CredentialInvalidException;
import com.pjtc.transport.UserNotFoundException;
import com.pjtc.transport.domain.User;
import com.pjtc.transport.service.UserService;
import com.pjtc.transport.web.Message;
import com.pjtc.transport.web.common.Constants;

@Controller
public class LocalAuthenticationController {
	
	private UserService userService;
	
	public LocalAuthenticationController(){
		
	}
	
	@Autowired(required=true)
	public void setUserService(UserService userService){
		this.userService = userService;
	}

    /**
     * @param transportOrder
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public void login(
		@RequestParam(required=true, value="userName") String userName, 
		@RequestParam(required=true, value="password") String password, 
		@RequestParam(required=false, value="originUrl") String originUrl,
		HttpServletRequest request, 
        HttpServletResponse response) 
				throws Exception {
    	
    	System.out.println("User login with " + userName + " password" + password);
    	
    	User user = userService.validateUser(userName, password);
    	
    	request.getSession().setAttribute(Constants.SESSION_ATTR_USER, user);
    	request.getSession().setMaxInactiveInterval(30*60);
    	
    	Cookie cookie = new Cookie("user", userName);
    	
    	response.addCookie(cookie);
    	
    	if (originUrl != null){
    		response.sendRedirect(originUrl);  
    	}		
    }
    
    @RequestMapping(value="/logout", method=RequestMethod.POST)
    public void logout(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
    	
    	request.getSession(false).invalidate();	
		
    }   

}