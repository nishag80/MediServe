package com.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.entity.Medicine;

@Service
public interface MedicineService {

	public Medicine createMedicine(Medicine medicine);

	public List<Medicine> getAllMedince();

	public Medicine getMedince(String medicineId);

	public Medicine updateMedicine(Medicine medicine, Medicine updatedMedicine);

	
}
