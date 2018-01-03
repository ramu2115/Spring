package com.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.dao.LoginDAO;
import com.bookshop.exception.DAOException;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public boolean validate(String userName, String password) throws DAOException {
		// TODO Auto-generated method stub
		return loginDAO.validateUser(userName, password);
	}

}
