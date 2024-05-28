package com.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.entity.Customer;
import com.edu.exception.SystemException;

@Service
public interface CustomerService {

	public Customer createCustomer(Customer medicine);

	public Customer getCustomer(Long customerId) throws SystemException;

	public Customer updateCustomer(Long customerId, Customer updatedMedicine) throws SystemException;

	public void deleteCustomer(Long medicineId) throws SystemException;

	List<Customer> getAllCustomer();

}
