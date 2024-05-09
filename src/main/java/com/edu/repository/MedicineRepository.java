package com.edu.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {
	
	public List<Medicine> findAll();

	public Medicine findBymedicineId(String medicineId);
	
	@Transactional
    @Query(value = "update medicine set total_sale_amount = total_sale_amount * :quantity , \r\n"
    		+ " quantity_sold = quantity_sold + :quantity , quantity_left = quantity_left - :quantity where \r\n"
    		+ " medicine_id = :productId ;")
	public void  updateSaleAmount(BigDecimal quantity,String productId);
	
	
	public List<Medicine> findBymedicineIdIn(List<String> medicineId);

}
