package com.pjtc.transport.web;

public class Message {
	
	public static final char MESSAGE_TYPE_INFO = 'I';
	public static final char MESSAGE_TYPE_WARNING = 'W';
	public static final char MESSAGE_TYPE_ERROR = 'E';
	
	private char messageType;
	
	private String message;

	public Message(char messageType, String message) {
		this.messageType = messageType;
		this.message = message;
	}

	public char getMessageType() {
		return messageType;
	}

	public String getMessage() {
		return message;
	}
	

}
