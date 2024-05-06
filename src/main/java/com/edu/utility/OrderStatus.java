package com.edu.utility;

public enum OrderStatus {

	CREATED("CREATED"), PENDING("PENDING"), SHIPPED("SHIPPED"), DELIVERED("DELIVERED"),CANCELLED("CANCELLED");

	private final String name;

	OrderStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
