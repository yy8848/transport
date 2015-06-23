package com.pjtc.transport.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;


public class HibernateAwareObjectMapper extends ObjectMapper {

    /**
	 * 
	 */
	private static final long serialVersionUID = 331428862938015154L;

	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}