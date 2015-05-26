package com.pjtc.transport;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.pjtc.transport.common.Constants;

public class ExceptionBase extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messageKey;
	private Object[] arguments;

	public ExceptionBase() {
		super();
	}

	public ExceptionBase(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionBase(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	public ExceptionBase(String messageKey, Object[] arguments) {
		super();
		this.messageKey = messageKey;
		this.arguments = arguments;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public Object[] getArguments() {
		return arguments;
	}

	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}

	public String getLocalizedMessage(Locale locale){
		// Can be optimized to just use one fixed locale
		ResourceBundle bundle = ResourceBundle.getBundle(Constants.RESOURCE_BUNDLE, locale);
		String message = bundle.getString(messageKey);
		return MessageFormat.format(message, arguments);
	}

}
