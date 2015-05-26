package com.pjtc.transport.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.InternalServerException;
import com.pjtc.transport.InvalidCredentialException;
import com.pjtc.transport.dao.UserDao;
import com.pjtc.transport.domain.Account;
import com.pjtc.transport.domain.User;
import com.pjtc.transport.security.PasswordHash;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public long createUser(User user) throws ExceptionBase {
		
		String hash;
		try {
			hash = PasswordHash.createHash(user.getPassword().toCharArray());
		} catch (NoSuchAlgorithmException e) {
			throw new InternalServerException(e.getMessage(), e);
		} catch (InvalidKeySpecException e) {
			throw new InternalServerException(e.getMessage(), e);
		}
		String[] parts = hash.split(":");
		user.setPassword(parts[1]);
		user.setSalt(parts[2]);
		
		return userDao.createUser(user);
	}

	public long createAccount(Account account) throws ExceptionBase {
		// TODO Auto-generated method stub
		return userDao.createAccount(account);
	}

	@Override
	public User validateUser(String userName, String password)
			throws ExceptionBase {
		
		User user = userDao.getUserByUserName(userName);
		try {
			if (!PasswordHash.validatePassword(password, user.getPassword())){
				throw new InvalidCredentialException();
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
