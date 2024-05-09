package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Items;

public interface OrderItemRepository extends JpaRepository<Items, Long> {

	public Items findByitemsId(Long orderItemId);

}
