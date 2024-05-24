package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public List<Customer> findAll();

	public Customer findBycustomerId(Long medicineId);

}
