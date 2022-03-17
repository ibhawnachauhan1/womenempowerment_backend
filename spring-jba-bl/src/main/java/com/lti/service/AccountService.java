package com.lti.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Activity;
import com.lti.exception.AccountException;

@Component
public class AccountService {
	@Autowired
	private GenericDao dao;

	@Transactional
	public void openAccount(Account account)    {
		if (account.getBalance() < 5000)
			throw new AccountException("sorry, can not open account.minimum 5000 rupees reqiuired");
		else {
			dao.save(account);
			//send an email confirmation
		}
	}
	@Transactional
	public void withdraw(int acno, double amount) {
		Account acc =dao.fetchByIdV2(Account.class, acno);
		if(acc.getBalance()<amount)
			throw new AccountException("Insufficient Balance!");
		else {
			acc.setBalance(acc.getBalance()-amount);
			dao.save(acc);
			
			Activity act = new Activity();
			act.setAmount(amount);
			act.setDateAndTime(LocalDateTime.now());
			act.setTxType("Withdraw");
			act.setAccount(acc);
			dao.save(act);
			
			
		}
	}
	@Transactional
	public void deposit(int acno, double amount) {
		Account acc =dao.fetchByIdV2(Account.class, acno);
		 
			acc.setBalance(acc.getBalance()+amount);
			dao.save(acc);
			
			Activity act = new Activity();
			act.setAmount(amount);
			act.setDateAndTime(LocalDateTime.now());
			act.setTxType("Deposit");
			act.setAccount(acc);
			dao.save(act);
	}
	@Transactional
	public void transfer(int fromAcno, int toAcno, double amount) {
	withdraw(fromAcno,amount);
	deposit(toAcno,amount);
	}

	public double balanceCheck(int acno) {
		return 0;
	}

}