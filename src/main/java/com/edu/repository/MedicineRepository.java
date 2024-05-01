package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {
	
	public List<Medicine> findAll();

	public Medicine findBymedicineId(String medicineId);

}
