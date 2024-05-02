package com.edu.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicine")
public class Medicine {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "medicine_id_generator")
	@GenericGenerator(name = "medicine_id_generator", strategy = "com.edu.service.MedicineIdGenerator")
	private String medicineId;
    
	@Column(nullable = false)
    private String name;
    private String description;
    private String manufacturer;
    private String category;
    private String dosageForm;
    private String activeIngredients;
    private String storageConditions;
    private String sideEffects;
    private String usageInstructions;
    private String prescriptionRequired;
    private String availability;
    private String image;
    private String barCode;
    private BigDecimal unitPrice; 
    @Column(nullable = false)
    private BigDecimal price; 
    private String remark;
    private BigDecimal totalSaleAmount;
	private Integer quantitySold;
	private Integer quantityLeft;
	private BigDecimal salesRevenue;
	private LocalDateTime lastSaleDate;

    
    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;
    
    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
 

}
