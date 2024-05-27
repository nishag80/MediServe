package com.edu.serviceIml;

import java.math.BigDecimal;

import com.edu.repository.MedicineRepository;
import com.edu.service.DashboardService;

public class DashboardServiceImp implements DashboardService{
	
	private MedicineRepository mediRepo;

	public BigDecimal getTotalSaleAmount() {
		
		return mediRepo.getTotalSaleAmt();
	}

}
