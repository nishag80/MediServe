package com.edu.serviceIml;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Medicine;
import com.edu.exception.ErrorType;
import com.edu.exception.SystemException;
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

	public Medicine getMedince(String medicineId) throws SystemException {
		Medicine medicine = medicineRepository.findBymedicineId(medicineId);
		if (null == medicine) {
			throw new SystemException(ErrorType.INVALID_MEDINCINE_ID, "Invalid MedicineId");
		}
		return medicine;
	}

	@Override
	public Medicine updateMedicine(String medicineId, Medicine updatedMedicine) throws SystemException {

		Medicine medicine = getMedince(medicineId);
		if (null == medicine) {
			throw new SystemException(ErrorType.INVALID_MEDINCINE_ID, "Invalid MedicineId");
		}
		if (null == updatedMedicine) {
			throw new SystemException(ErrorType.MISSING_PARAM, "Invalid Medicine details");
		}

		if (StringUtils.isNotBlank(updatedMedicine.getName())) {
			medicine.setName(updatedMedicine.getName());
		}

		if (null != updatedMedicine.getDescription()) {
			medicine.setDescription(updatedMedicine.getDescription());
		}

		if (null != updatedMedicine.getManufacturer()) {
			medicine.setManufacturer(updatedMedicine.getManufacturer());
		}

		if (null != updatedMedicine.getCategory()) {
			medicine.setCategory(updatedMedicine.getCategory());
		}

		if (null != updatedMedicine.getDosageForm()) {
			medicine.setDosageForm(updatedMedicine.getDosageForm());
		}

		if (null != updatedMedicine.getActiveIngredients()) {
			medicine.setActiveIngredients(updatedMedicine.getActiveIngredients());
		}

		if (null != updatedMedicine.getStorageConditions()) {
			medicine.setStorageConditions(updatedMedicine.getStorageConditions());
		}

		if (null != updatedMedicine.getSideEffects()) {
			medicine.setSideEffects(updatedMedicine.getSideEffects());
		}

		if (null != updatedMedicine.getUsageInstructions()) {
			medicine.setUsageInstructions(updatedMedicine.getUsageInstructions());
		}

		if (null != updatedMedicine.getPrescriptionRequired()) {
			medicine.setPrescriptionRequired(updatedMedicine.getPrescriptionRequired());
		}

		if (null != updatedMedicine.getAvailability()) {
			medicine.setAvailability(updatedMedicine.getAvailability());
		}

		if (null != updatedMedicine.getImage()) {
			medicine.setImage(updatedMedicine.getImage());
		}

		if (null != updatedMedicine.getBarCode()) {
			medicine.setBarCode(updatedMedicine.getBarCode());
		}

		if (StringUtils.isNotBlank(updatedMedicine.getName())) {
			medicine.setUnitPrice(updatedMedicine.getUnitPrice());
		}

		if (null != updatedMedicine.getPrice()) {
			medicine.setPrice(updatedMedicine.getPrice());
		}

		if (null != updatedMedicine.getRemark()) {
			medicine.setRemark(updatedMedicine.getRemark());
		}

		if (null != updatedMedicine.getTotalSaleAmount()) {
			medicine.setTotalSaleAmount(updatedMedicine.getTotalSaleAmount());
		}

		if (null != updatedMedicine.getQuantitySold()) {
			medicine.setQuantitySold(updatedMedicine.getQuantitySold());
		}

		if (null != updatedMedicine.getQuantityLeft()) {
			medicine.setQuantityLeft(updatedMedicine.getQuantityLeft());
		}

		if (null != updatedMedicine.getSalesRevenue()) {
			medicine.setSalesRevenue(updatedMedicine.getSalesRevenue());
		}

		if (null != updatedMedicine.getLastSaleDate()) {
			medicine.setLastSaleDate(updatedMedicine.getLastSaleDate());
		}

		medicine.setUpdatedDate(LocalDateTime.now());
		return medicineRepository.save(medicine);
	}

	@Override
	public void deleteMedicine(String medicineId) {
		medicineRepository.deleteById(medicineId);
	}

}
