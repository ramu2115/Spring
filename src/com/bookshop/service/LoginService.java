package com.bookshop.service;

import com.bookshop.exception.DAOException;

public interface LoginService {
	
	boolean validate(String userName, String password) throws DAOException;

}
