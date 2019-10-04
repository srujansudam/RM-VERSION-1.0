package com.cg.ibs.remittancemgmt.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.cg.ibs.remittancemgmt.bean.Beneficiary;
import com.cg.ibs.remittancemgmt.bean.Customer;
import com.cg.ibs.remittancemgmt.exception.RmExceptions;

public class BeneficiaryDAOImpl implements BeneficiaryDAO {
	private static Customer customer = new Customer();
	private static Map<String, Customer> finalMap = new HashMap<>();
	private static ArrayList<Beneficiary> savedBeneficiaries = new ArrayList<>();
	Beneficiary beneficiary = new Beneficiary();

	@Override
	public ArrayList<Beneficiary> getDetails(String UCI) {
		// TODO Auto-generated method stub
		return finalMap.get(UCI).getSavedBeneficiaries();
	}

	@Override
	public void copyDetails(String UCI, Beneficiary beneficiary) throws RmExceptions {
		// TODO Auto-generated method stub
		if (finalMap.get(UCI).getSavedBeneficiaries().contains(beneficiary)) {
			throw new RmExceptions("Beneficiary already added");
		} else {
			savedBeneficiaries.add(beneficiary);
			customer.setSavedBeneficiaries(savedBeneficiaries);
			finalMap.put(UCI, customer);
		}

	}

	@Override
	public boolean updateDetails(String UCI, Beneficiary beneficiary) {
		// TODO Auto-generated method stub
		
		customer.setSavedBeneficiaries(savedBeneficiaries);
	}

	@Override
	public boolean deleteDetails(String UCI, BigInteger accountNumber) throws RmExceptions {
		// TODO Auto-generated method stub
		boolean result = false;

		if (null == finalMap.get(UCI).getSavedBeneficiaries()) {
			throw new RmExceptions("Beneficiary doesn't exist");

		} else {

			for (Beneficiary beneficiary : finalMap.get(UCI).getSavedBeneficiaries()) {

				if (beneficiary.getAccountNumber().equals(accountNumber)) {
					savedBeneficiaries.remove(beneficiary);
					result = true;
				}
			}
			return result;
		}

	}

}
