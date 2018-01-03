package com.bookshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop.model.LoginForm;
import com.bookshop.service.LoginService;

@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm()
	{
		return new ModelAndView("login", "loginForm", new LoginForm());
	}
	
	
	public ModelAndView handleRequest(@Valid LoginForm loginForm, BindingResult result, HttpServletRequest request)
	{
		ModelAndView mav = null;
		String userName = null;
		String password = null;
		boolean flag = false;
		if(result.hasErrors())
		{
			mav = new ModelAndView("login");
		}
		else
		{
			userName=loginForm.getUserName();
			password=loginForm.getPassword();
			try {
				// Validate user against DB
				flag = loginService.validate(userName, password);
			}
			catch(Exception e) {
				mav = new ModelAndView("error", "ERROR_KEY", "Unable to process your request, Please try again..!");
				logger.error("Error is due to : " + e.getMessage());
			}
			
		}
		return mav;
	}
	

}
