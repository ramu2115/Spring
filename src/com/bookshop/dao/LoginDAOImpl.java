package com.bookshop.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookshop.exception.DAOException;
import com.bookshop.model.SystemUsers;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	private static final Logger logger = Logger.getLogger(LoginDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean validateUser(String username, String password) throws DAOException {
		// TODO Auto-generated method stub
		logger.debug("Enter");
		Session session = null;
		boolean flag = false;
		try
		{
			session = sessionFactory.getCurrentSession();
			String HQL = "FROM SystemUsers WHERE userName = '"+username+"' and password = '"+password+"'";
			Query query = session.createQuery(HQL);
			List<SystemUsers> list = query.list();
			if(list == null || list.isEmpty()) {
				flag = false;
			}
			else {
				flag = true;
			}
			
		}
		catch(HibernateException he)
		{
			logger.error("Error while validating user:"+he.getMessage());
			throw new DAOException();
		}
		logger.debug("exit");
		return flag;
		
		
	}

}
