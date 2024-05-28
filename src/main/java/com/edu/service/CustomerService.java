package com.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.entity.Customer;
import com.edu.exception.SystemException;

@Service
public interface CustomerService {

	public Customer createCustomer(Customer customer);

	public Customer getCustomer(Long customerId) throws SystemException;

	public Customer updateCustomer(Long customerId, Customer updatedCustomer) throws SystemException;

	public void deleteCustomer(Long productId) throws SystemException;

	List<Customer> getAllCustomer();

}
