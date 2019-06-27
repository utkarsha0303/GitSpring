package com.bankapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.customException.CustomException;
import com.bankapp.entity.Customer;
import com.bankapp.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Override
	public String createCustomer(Customer customer) {
		String successMessage = null;
		Customer customers = new Customer();
		if (customer != null) {
			int noOfAcc = customerRepo.findByPan(customer.getPan());
			if (noOfAcc >= 2) {
				throw new CustomException("Maximum Account Limit Exceeds!!");
			} else if (customerRepo.save(customer) != null&& noOfAcc <2) {
				successMessage = "Contrags! Customer created.";
			} else {
				successMessage = "Failed to create customer.";
			}

			

		}
		 return successMessage;
	}
     
}

