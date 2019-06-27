package com.bankapp.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bankapp.entity.Customer;
import com.bankapp.repository.CustomerRepo;
import com.bankapp.services.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;

	@Mock
	private CustomerRepo customerRepo;

	@Test
	public void createAccount() {
		Customer customer = new Customer(11, "Navya Jio", 889, "Female", "Blore", "AKJJS99K");
		String expectedMessage = "Contrags! Customer created.";
		
		Mockito.when(customerRepo.save(Mockito.anyObject())).thenReturn(customer);
		String actualMessage = customerServiceImpl.createCustomer(customer);

		assertEquals(expectedMessage, actualMessage);

	}

}
