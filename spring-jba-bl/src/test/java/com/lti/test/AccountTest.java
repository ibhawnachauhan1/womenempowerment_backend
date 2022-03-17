package com.lti.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.entity.Account;

import com.lti.service.AccountService;

public class AccountTest {

	@Test
	public void checkingOpeningAnAccount() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		AccountService accServ =(AccountService) ctx.getBean("accountService");
		Account acc = new Account();
		acc.setName("Bhawna Chauhan");
		acc.setType("Savings");
		acc.setBalance(5000);
		accServ.openAccount(acc);
	}
	
	@Test
	public void checkwithDrawal()   {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		AccountService accServ = (AccountService) ctx.getBean("accountService");
		accServ.withdraw(76,1000); // check the acno before you run
}
	
	@Test
	public void checkwithTransfer()   {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		AccountService accServ = (AccountService) ctx.getBean("accountService");
		accServ.withdraw(77, 5000);
		accServ.deposit(79, 5000);
	}
}