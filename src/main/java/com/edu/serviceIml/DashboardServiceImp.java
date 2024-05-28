package com.edu.serviceIml;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.repository.ProductRepository;
import com.edu.service.DashboardService;
@Service
public class DashboardServiceImp implements DashboardService {

	@Autowired
	private ProductRepository mediRepo;

	@Override
	public BigDecimal getTotalSaleAmount() {
		return mediRepo.getTotalSaleAmt();
	}

	

}
