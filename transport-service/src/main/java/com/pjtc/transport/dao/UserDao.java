package com.pjtc.transport.dao;

import com.pjtc.transport.CredentialInvalidException;
import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.UserNotFoundException;
import com.pjtc.transport.domain.Account;
import com.pjtc.transport.domain.User;

public interface UserDao {
	
	public long createUser(User user) throws ExceptionBase;
	
	public long createAccount(Account account) throws ExceptionBase;
	
	public User getUserByUserName(String userName) throws 
		UserNotFoundException, ExceptionBase;

}
