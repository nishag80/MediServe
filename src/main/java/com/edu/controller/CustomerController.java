package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.entity.Customer;
import com.edu.exception.SystemException;
import com.edu.service.CustomerService;
import com.edu.utility.ApiResponse;
import com.edu.utility.RequestValidator;
import com.edu.utility.StatusType;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private RequestValidator requestValidator;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCustomer(@RequestBody Customer customer) {
		try {
			requestValidator.validateCustomerRequest(customer);
			Customer createdCustomer = customerService.createCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(
					new ApiResponse(StatusType.SUCCESS.getName(), "Customer created successfully", createdCustomer));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}
	}

	@GetMapping
	public ResponseEntity<ApiResponse> getAllCustomer() {
		try {
			List<Customer> allMedicines = customerService.getAllCustomer();
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), allMedicines));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<ApiResponse> getCustomer(@PathVariable Long customerId) throws SystemException {
		try {
			Customer customer = customerService.getCustomer(customerId);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), customer));
		} catch (SystemException e) {
	        throw e;
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<ApiResponse> updateCustomer(@RequestBody Customer updatedCustomer,@PathVariable Long customerId) throws SystemException {
		try {
			Customer updatedCust = customerService.updateCustomer(customerId,updatedCustomer);
			
			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), updatedCust));
		} catch (SystemException e) {
	        throw e;
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Long customerId) {
		try {
			Customer customer = customerService.getCustomer(customerId);
			customerService.deleteCustomer(customerId);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(),"customer " + customer.getName()
					+ " deleted successfully"));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}

}
