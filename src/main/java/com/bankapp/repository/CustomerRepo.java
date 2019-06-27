package com.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bankapp.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	@Query(value = "SELECT count(*) FROM customer cust WHERE cust.pan = ?1", nativeQuery = true)
	public int findByPan(String pan);
}

