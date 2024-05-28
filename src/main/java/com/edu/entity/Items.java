package com.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Items")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemsId;

//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name = "orderId", nullable = false)
//	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = false)
	private Product product;

	@Column(nullable = false)
	private Integer quantity;

}
