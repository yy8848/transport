package com.pjtc.transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.pjtc.transport.InvalidCredentialException;
import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.UserNotFoundException;
import com.pjtc.transport.domain.Account;
import com.pjtc.transport.domain.User;

public class UserDaoImpl extends DaoImplBase implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public long createUser(User user) throws ExceptionBase {
		return (Long)getSession().save(user);
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
