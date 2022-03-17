package com.lti.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbl_account")
public class Account {

	@Id
	@GeneratedValue
	private int accountNo;

	private String name;
	private String type;
	private double balance;

	@OneToMany(mappedBy = "account")
	private List<Activity> activities;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

}