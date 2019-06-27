package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entity.Customer;
import com.bankapp.services.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/Create")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		String successMessage = customerService.createCustomer(customer);

		return new ResponseEntity<String>(successMessage, HttpStatus.OK);

	}
}
