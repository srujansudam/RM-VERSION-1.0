package com.cg.ibs.remittancemgmt.bean;

import java.math.BigInteger;
import java.util.Date;

public class CreditCard {
	private BigInteger creditCardNumber;
	private String nameOnCreditCard;
	private Date creditDateOfExpiry;

	public CreditCard() {
		super();
	}

	public CreditCard(BigInteger creditCardNumber, String nameOnCreditCard, Date creditDateOfExpiry) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.nameOnCreditCard = nameOnCreditCard;
		this.creditDateOfExpiry = creditDateOfExpiry;
	}

	@Override
	public String toString() {
		return "CreditCard [creditCardNumber=" + creditCardNumber + ", nameOnCreditCard=" + nameOnCreditCard
				+ ", creditDateOfExpiry=" + creditDateOfExpiry + "]";
	}

	public BigInteger getcreditCardNumber() {
		return creditCardNumber;
	}

	public void setcreditCardNumber(BigInteger creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getnameOnCreditCard() {
		return nameOnCreditCard;
	}

	public void setnameOnCreditCard(String nameOnCreditCard) {
		this.nameOnCreditCard = nameOnCreditCard;
	}

	public Date getcreditDateOfExpiry() {
		return creditDateOfExpiry;
	}

	public void setcreditDateOfExpiry(Date creditDateOfExpiry) {
		this.creditDateOfExpiry = creditDateOfExpiry;
	}

}
