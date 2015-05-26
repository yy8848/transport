package com.pjtc.transport.service;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.domain.Account;
import com.pjtc.transport.domain.User;

public interface UserService {
	
	public long createUser(User user) throws ExceptionBase;
	
	public long createAccount(Account account) throws ExceptionBase;
	
	public User validateUser(String userName, String password) throws ExceptionBase;	

}
