package com.cg.ibs.remittancemgmt.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cg.ibs.remittancemgmt.bean.Beneficiary;
import com.cg.ibs.remittancemgmt.bean.CreditCard;
import com.cg.ibs.remittancemgmt.bean.Customer;
import com.cg.ibs.remittancemgmt.exception.RmExceptions;

public class CreditCardDAOImpl implements CreditCardDAO {
	private static Customer customer = new Customer();
	private static Map<String, Customer> finalMap = new HashMap<>();
	private static Set<CreditCard> savedCreditCards = new HashSet<>();
	CreditCard creditCard = new CreditCard();
	@Override
	public List<CreditCard> getDetails(String UCI) {
		// TODO Auto-generated method stub
		return (List<CreditCard>) finalMap.get(UCI).getSavedCreditCards();
	}

	@Override
	public void copyDetails(String UCI, CreditCard card) throws RmExceptions {
		// TODO Auto-generated method stub
		if (finalMap.get(UCI).getSavedCreditCards().contains(card)) {
			throw new RmExceptions("Credit card already added");
		} else {
			savedCreditCards.add(card);
			customer.setSavedCreditCards(savedCreditCards);
			finalMap.put(UCI, customer);
		}
	}

	@Override
	public boolean updateDetails(String UCI, BigInteger cardNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDetails(String UCI, BigInteger cardNumber) throws RmExceptions {
		// TODO Auto-generated method stub
		boolean result = false;

		if (null == finalMap.get(UCI).getSavedCreditCards()) {
			throw new RmExceptions("Credit Card doesn't exist");

		} else {

			for (CreditCard card : finalMap.get(UCI).getSavedCreditCards()) {

				if (creditCard.getcreditCardNumber().equals(cardNumber)) {
					savedCreditCards.remove(card);
					result = true;
				}
			}
			return result;
		}
	}

}
