package com.edu.serviceIml;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Medicine;
import com.edu.repository.MedicineRepository;
import com.edu.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	public Medicine createMedicine(Medicine medicine) {
		initializeAnalyticsDefaults(medicine);
		return medicineRepository.save(medicine);
	}

	private void initializeAnalyticsDefaults(Medicine medicine) {
		medicine.setTotalSaleAmount(BigDecimal.ZERO);
		medicine.setQuantitySold(0);
		medicine.setSalesRevenue(BigDecimal.ZERO);
	}

	@Override
	public List<Medicine> getAllMedince() {
		
		return medicineRepository.findAll();
	}

	public Medicine getMedince(String medicineId) {
		return medicineRepository.findBymedicineId(medicineId);
	}


	@Override
	public Medicine updateMedicine(Medicine medicine, Medicine updatedMedicine) {
		
		medicine.setName(updatedMedicine.getName());
	    medicine.setDescription(updatedMedicine.getDescription());
	    medicine.setManufacturer(updatedMedicine.getManufacturer());
	    medicine.setCategory(updatedMedicine.getCategory());
	    medicine.setDosageForm(updatedMedicine.getDosageForm());
	    medicine.setActiveIngredients(updatedMedicine.getActiveIngredients());
	    medicine.setStorageConditions(updatedMedicine.getStorageConditions());
	    medicine.setSideEffects(updatedMedicine.getSideEffects());
	    medicine.setUsageInstructions(updatedMedicine.getUsageInstructions());
	    medicine.setPrescriptionRequired(updatedMedicine.getPrescriptionRequired());
	    medicine.setAvailability(updatedMedicine.getAvailability());
	    medicine.setImage(updatedMedicine.getImage());
	    medicine.setBarCode(updatedMedicine.getBarCode());
	    medicine.setUnitPrice(updatedMedicine.getUnitPrice());
	    medicine.setPrice(updatedMedicine.getPrice());
	    medicine.setRemark(updatedMedicine.getRemark());
	    medicine.setTotalSaleAmount(updatedMedicine.getTotalSaleAmount());
	    medicine.setQuantitySold(updatedMedicine.getQuantitySold());
	    medicine.setQuantityLeft(updatedMedicine.getQuantityLeft());
	    medicine.setSalesRevenue(updatedMedicine.getSalesRevenue());
	    medicine.setLastSaleDate(updatedMedicine.getLastSaleDate());
	    medicine.setUpdatedDate(LocalDateTime.now());
	    return medicineRepository.save(medicine);
	}

}
