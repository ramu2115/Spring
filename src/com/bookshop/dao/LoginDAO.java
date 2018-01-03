package com.bookshop.dao;

import com.bookshop.exception.DAOException;

public interface LoginDAO {
	boolean validateUser(String username, String password) throws DAOException;

}
