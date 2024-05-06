package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	public OrderItem findByorderItemid(Long orderItemId);

}
