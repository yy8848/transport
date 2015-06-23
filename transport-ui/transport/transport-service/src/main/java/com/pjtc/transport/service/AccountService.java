package com.pjtc.transport.service;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.domain.Account;

public interface AccountService {
	
	public long createAccount(Account account) throws ExceptionBase;

}

