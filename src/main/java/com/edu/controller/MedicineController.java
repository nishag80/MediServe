package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.entity.Medicine;
import com.edu.service.MedicineService;
import com.edu.utility.ApiResponse;
import com.edu.utility.RequestValidator;
import com.edu.utility.StatusType;

@RestController
@RequestMapping("/api/v1/medicine")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@Autowired
	private RequestValidator requestValidator;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createMedicine(@RequestBody Medicine medicine) {
		try {
			requestValidator.validateMedicineRequest(medicine);
			Medicine createdMedicine = medicineService.createMedicine(medicine);
			return ResponseEntity.status(HttpStatus.CREATED).body(
					new ApiResponse(StatusType.SUCCESS.getName(), "Medicine created successfully", createdMedicine));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}
	}

	@GetMapping
	public ResponseEntity<ApiResponse> getAllMedicine() {
		try {
			List<Medicine> allMedicines = medicineService.getAllMedince();
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), allMedicines));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
	
	@GetMapping("/{medicineId}")
	public ResponseEntity<ApiResponse> getMedicine(@PathVariable String medicineId) {
		try {
			Medicine medicines = medicineService.getMedince(medicineId);
			if(null==medicines) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ApiResponse(StatusType.NOT_FOUND.getCode(), StatusType.NOT_FOUND.getName(), "Invalid Medicine Id"));
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), medicines));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
	
	@PutMapping("/{medicineId}")
	public ResponseEntity<ApiResponse> updateMedicine(@RequestBody Medicine updatedMedicine,@PathVariable String medicineId) {
		try {
			Medicine medicine = medicineService.getMedince(medicineId);
			if(null==medicine) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ApiResponse(StatusType.NOT_FOUND.getCode(), StatusType.NOT_FOUND.getName(), "Invalid Medicine Id"));
			}
			if(null==updatedMedicine) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ApiResponse(StatusType.MISSING_PARAM.getCode(), StatusType.MISSING_PARAM.getName(), "Invalid updated Details"));
			}
			Medicine updatedMed = medicineService.updateMedicine(medicine,updatedMedicine);
			
			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), updatedMed));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
	
	@DeleteMapping("/{medicineId}")
	public ResponseEntity<ApiResponse> deleteMedicine(@PathVariable String medicineId) {
		try {
			Medicine medicine = medicineService.getMedince(medicineId);
			if(null==medicine) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ApiResponse(StatusType.NOT_FOUND.getCode(), StatusType.NOT_FOUND.getName(), "Invalid Medicine Id"));
			}
			medicineService.deleteMedicine(medicineId);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(),"Medicine : " + medicine.getMedicineId()
					+ "deleted successfully"));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
}
