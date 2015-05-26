package com.pjtc.transport;

import com.pjtc.transport.common.Constants;

public class InvalidCredentialException extends ExceptionBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6907319301208228720L;

	public InvalidCredentialException() {
		super(Constants.MSG_KEY_CREDENTIAL_NOT_VALID, new Object[0]);
	}

}
