package com.edu.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public interface DashboardService {
	
	public BigDecimal getTotalSaleAmount();

}
