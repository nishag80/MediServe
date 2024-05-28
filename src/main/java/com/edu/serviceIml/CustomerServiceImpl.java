package com.edu.serviceIml;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Customer;
import com.edu.exception.ErrorType;
import com.edu.exception.SystemException;
import com.edu.repository.CustomerRepository;
import com.edu.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Customer createCustomer(Customer customer) {
		return custRepo.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return custRepo.findAll();
	}

	@Override
	public Customer getCustomer(Long customerId) throws SystemException {
		return custRepo.findBycustomerId(customerId);
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer updatedProduct) throws SystemException {
		Customer customer = custRepo.findBycustomerId(customerId);
		if(customer==null) {
			throw new SystemException(ErrorType.NOT_FOUND,"Invalid customer");
		}
		if(updatedProduct==null) {
			throw new SystemException(ErrorType.MISSING_PARAM,"Invalid customer detail");
		}
		if (StringUtils.isNotBlank(updatedProduct.getName())) {
			customer.setName(updatedProduct.getName());
		}

		if (null != updatedProduct.getAddress()) {
			customer.setAddress(updatedProduct.getAddress());
		}

		if (null != updatedProduct.getPinCode()) {
			customer.setPinCode(updatedProduct.getPinCode());
		}

		if (null != updatedProduct.getPhoneNumbers()) {
			customer.setPhoneNumbers(updatedProduct.getPhoneNumbers());
		}
		
		return custRepo.save(customer);
	}

	@Override
	public void deleteCustomer(Long customerId) throws SystemException {
		Customer customer = custRepo.findBycustomerId(customerId);
		if(customer==null) {
			throw new SystemException(ErrorType.NOT_FOUND,"Invalid customer");
		}	
		custRepo.delete(customer);
		
	}

}
