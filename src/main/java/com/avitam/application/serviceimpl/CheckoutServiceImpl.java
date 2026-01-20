package com.avitam.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.avitam.application.dao.CheckoutDao;
import com.avitam.application.service.CheckoutService;

public class CheckoutServiceImpl implements CheckoutService{

	@Autowired
	private CheckoutDao checkoutDao;

	public void setCheckoutDao(CheckoutDao checkoutDao) {
		this.checkoutDao = checkoutDao;
	}
	
	
}
