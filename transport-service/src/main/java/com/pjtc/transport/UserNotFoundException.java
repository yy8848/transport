package com.pjtc.transport;

import com.pjtc.transport.common.Constants;

public class UserNotFoundException extends ExceptionBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4670463073362232585L;

	public UserNotFoundException(String userName) {
		super(Constants.MSG_KEY_USER_NOT_FOUND, new String[]{userName});
	}

}
