package com.pjtc.transport.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoImplBase {
	
	private ThreadLocal<Session> session = new ThreadLocal<Session>();	

	private SessionFactory sessionFactory;	
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}	
	
	protected Session getSession(){
		if (session.get() == null){
			session.set(sessionFactory.openSession());
		}
		return session.get();
	}

}
