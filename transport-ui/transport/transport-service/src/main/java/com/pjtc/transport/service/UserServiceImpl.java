package com.pjtc.transport.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.InternalServerException;
import com.pjtc.transport.CredentialInvalidException;
import com.pjtc.transport.dao.UserDao;
import com.pjtc.transport.domain.Account;
import com.pjtc.transport.domain.User;
import com.pjtc.transport.security.PasswordHash;

public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserDao userDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public long createUser(User user) throws ExceptionBase {
		
		logger.info("Create user {}", user.getUserName());
		
		String hash;
		try {
			hash = PasswordHash.createHash(user.getPassword().toCharArray());
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
			throw new InternalServerException(e.getMessage(), e);
		} catch (InvalidKeySpecException e) {
			throw new InternalServerException(e.getMessage(), e);
		}
		
		user.setPassword(hash);
		
		return userDao.createUser(user);
	}

	public long createAccount(Account account) throws ExceptionBase {
		
		long id = 0;
		id = userDao.createAccount(account);
		return id;
	}

	@Override
	public User validateUser(String userName, String password)
			throws ExceptionBase {
		
		User user = userDao.getUserByUserName(userName);
		try {
			if (!PasswordHash.validatePassword(password, user.getPassword())){
				throw new CredentialInvalidException();
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new InternalServerException(e.getMessage(), e);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			throw new InternalServerException(e.getMessage(), e);
		};
		
		user.setPassword(null);
		return user;
	}

}
