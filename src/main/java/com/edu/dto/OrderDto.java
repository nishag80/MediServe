package com.edu.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

	public Long customerId;

	public List<ItemDto> items;

}

