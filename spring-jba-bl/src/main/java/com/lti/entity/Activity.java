package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_activity")

public class Activity {
	@Id
	@GeneratedValue
	private int txNo;

	private LocalDateTime dateTime;
	private String txType;
	private double amount;

	@ManyToOne
	@JoinColumn(name = "acno")
	private Account account; /// we will noot use the private int accountNo instid of that we use the Class
								/// name and refernce for making foreign key

	public int getTxNo() {
		return txNo;
	}

	public void setTxNo(int txNo) {
		this.txNo = txNo;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateAndTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}