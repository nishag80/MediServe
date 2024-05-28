package com.edu.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.service.DashboardService;
import com.edu.utility.ApiResponse;
import com.edu.utility.StatusType;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

	@Autowired
	public DashboardService dashboardService;

	@GetMapping
	public ResponseEntity<ApiResponse> getAllCustomer() {
		try {
			BigDecimal totalSaleAmt = dashboardService.getTotalSaleAmount();
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), totalSaleAmt));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}

}
