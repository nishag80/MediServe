package com.edu.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {

	public List<Medicine> findAll();

	public Medicine findBymedicineId(String medicineId);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE Medicine "
	        + "SET total_sale_amount = total_sale_amount + (:unitPrice * :quantity),"
	        + "sales_revenue =  sales_revenue + (:unitPrice * :quantity),"
	        + "quantity_sold = quantity_sold + :quantity, "
	        + "quantity_left = quantity_left - :quantity, "
	        + "last_sale_date = NOW() "
	        + "WHERE medicine_id = :productId")
	public void updateSaleAmount(@Param("quantity") int quantity, 
	                             @Param("unitPrice") BigDecimal unitPrice, 
	                             @Param("productId") String productId);
	
	 @Query("SELECT SUM(m.totalSaleAmount) FROM Medicine m")
	 public BigDecimal getTotalSaleAmt();


	public List<Medicine> findBymedicineIdIn(List<String> medicineId);

}
