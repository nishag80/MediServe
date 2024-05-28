package com.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.entity.Order;
import com.edu.exception.SystemException;

@Service
public interface OrderService {
	
	public Order createOrder(Order orderDetails) throws SystemException;
	
	public List<Order> getAllOrders();
	
	public Order getOrderById(Long orderId);
	
	public Order updateOrder(Long orderId,Order order) throws SystemException;

	void deleteOrder(Order order,Long customerId) throws SystemException;

}
