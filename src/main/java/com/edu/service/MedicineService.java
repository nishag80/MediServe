package com.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.entity.Medicine;
import com.edu.exception.SystemException;

@Service
public interface MedicineService {

	public Medicine createMedicine(Medicine medicine);

	public List<Medicine> getAllMedince();

	public Medicine getMedince(String medicineId) throws SystemException;

	public Medicine updateMedicine(String medicineId, Medicine updatedMedicine) throws SystemException;

	public void deleteMedicine(String medicineId);

	
}
