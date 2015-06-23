package com.pjtc.transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.pjtc.transport.CredentialInvalidException;
import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.UserNotFoundException;
import com.pjtc.transport.common.Constants;
import com.pjtc.transport.domain.Account;
import com.pjtc.transport.domain.User;

import org.hibernate.exception.ConstraintViolationException;

public class UserDaoImpl extends DaoImplBase implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public long createUser(User user) throws ExceptionBase {
		long id = -1;
		try{
			id = (Long)getSession().save(user);
		} catch (org.hibernate.exception.ConstraintViolationException ex){
			
			String message = ex.getMessage();

			// To-do: make this configurable
			// Define constants for constraint
			if (message.indexOf("user_name") > 0){
				throw new com.pjtc.transport.ValidationException(
					Constants.MSG_KEY_USER_NAME_DUPLICATE, 
					new String[] {user.getUserName()});
			}
		}
		return id;
	}
		
	public long createAccount(Account account) throws ExceptionBase {
		return (Long)getSession().save(account);
	}

	public User getUserByUserName(String userName)
			throws UserNotFoundException, ExceptionBase {
		Criteria criteria = getSession().createCriteria(User.class).
			add(Restrictions.eq("userName", userName));
		
		@SuppressWarnings("unchecked")
		List<User> users = criteria.list();
		
		if (users == null || users.size() == 0){
			throw new UserNotFoundException(userName);
		}
		
		User user = users.get(0);		
		
		return user;
	}
	
	

}
