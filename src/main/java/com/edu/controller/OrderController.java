package com.edu.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.edu.entity.Order;
import com.edu.exception.SystemException;
import com.edu.service.OrderService;
import com.edu.utility.ApiResponse;
import com.edu.utility.RequestValidator;
import com.edu.utility.StatusType;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private RequestValidator requestValidator;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCustomer(@RequestBody Order order) {
		try {
			// requestValidator.validateCustomerRequest(customer);
			// Order ord = this.modelMapper.map(order, Order.class);
			Order createdOrder = orderService.createOrder(order);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ApiResponse(StatusType.SUCCESS.getName(), "Order created successfully", createdOrder));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}
	}

	@GetMapping
	public ResponseEntity<ApiResponse> getAllCustomer() {
		try {
			List<Order> allOrders = orderService.getAllOrders();
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), allOrders));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}

	@GetMapping("/{orderId}")
	public ResponseEntity<ApiResponse> getCustomer(@PathVariable Long orderId) throws SystemException {
		try {
			Order order = orderService.getOrderById(orderId);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), order));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}

	@PutMapping("/{orderId}")
	public ResponseEntity<ApiResponse> updateCustomer(@RequestBody Order updatedOrder, @PathVariable Long orderId)
			throws SystemException {
		try {
			Order updatedOrdr = orderService.updateOrder(orderId, updatedOrder);

			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), updatedOrdr));
		} catch (SystemException e) {
			throw e;
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Long orderId) {
		try {
			Order order = orderService.getOrderById(orderId);
			orderService.deleteOrder(order, orderId);
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(StatusType.SUCCESS.getCode(),
					StatusType.SUCCESS.getDescription(), "customer " + order.getOrderId() + " deleted successfully"));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}

}
