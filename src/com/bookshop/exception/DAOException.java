package com.bookshop.exception;

public class DAOException extends Exception {
	
	public DAOException() {
		super();
	}

	public DAOException(String aMessage) {
		super(aMessage);
	}

	public DAOException(String aMessage, Throwable aException) {
		super(aMessage, aException);
	}

	public DAOException(Throwable aException) {
		super(aException);
	}

}
