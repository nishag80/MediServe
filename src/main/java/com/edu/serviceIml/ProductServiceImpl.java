package com.edu.serviceIml;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Product;
import com.edu.exception.ErrorType;
import com.edu.exception.SystemException;
import com.edu.repository.ProductRepository;
import com.edu.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product createProduct(Product product) {
		initializeAnalyticsDefaults(product);
		return productRepository.save(product);
	}

	private void initializeAnalyticsDefaults(Product product) {
		product.setTotalSaleAmount(BigDecimal.ZERO);
		product.setQuantitySold(0);
		product.setSalesRevenue(BigDecimal.ZERO);
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public Product getProduct(String productId) throws SystemException {
		Product product = productRepository.findByproductId(productId);
		if (null == product) {
			throw new SystemException(ErrorType.INVALID_PRODUCT_ID, "Invalid ProductId");
		}
		return product;
	}

	@Override
	public Product updateProduct(String productId, Product updatedProduct) throws SystemException {

		Product product = getProduct(productId);
		if (null == product) {
			throw new SystemException(ErrorType.INVALID_PRODUCT_ID, "Invalid ProductId");
		}
		if (null == updatedProduct) {
			throw new SystemException(ErrorType.MISSING_PARAM, "Invalid Product details");
		}

		if (StringUtils.isNotBlank(updatedProduct.getName())) {
			product.setName(updatedProduct.getName());
		}

		if (null != updatedProduct.getDescription()) {
			product.setDescription(updatedProduct.getDescription());
		}

		if (null != updatedProduct.getManufacturer()) {
			product.setManufacturer(updatedProduct.getManufacturer());
		}

		if (null != updatedProduct.getCategory()) {
			product.setCategory(updatedProduct.getCategory());
		}

		if (null != updatedProduct.getDosageForm()) {
			product.setDosageForm(updatedProduct.getDosageForm());
		}

		if (null != updatedProduct.getActiveIngredients()) {
			product.setActiveIngredients(updatedProduct.getActiveIngredients());
		}

		if (null != updatedProduct.getStorageConditions()) {
			product.setStorageConditions(updatedProduct.getStorageConditions());
		}

		if (null != updatedProduct.getSideEffects()) {
			product.setSideEffects(updatedProduct.getSideEffects());
		}

		if (null != updatedProduct.getUsageInstructions()) {
			product.setUsageInstructions(updatedProduct.getUsageInstructions());
		}

		if (null != updatedProduct.getPrescriptionRequired()) {
			product.setPrescriptionRequired(updatedProduct.getPrescriptionRequired());
		}

		if (null != updatedProduct.getAvailability()) {
			product.setAvailability(updatedProduct.getAvailability());
		}

		if (null != updatedProduct.getImage()) {
			product.setImage(updatedProduct.getImage());
		}

		if (null != updatedProduct.getBarCode()) {
			product.setBarCode(updatedProduct.getBarCode());
		}

		if (StringUtils.isNotBlank(updatedProduct.getName())) {
			product.setUnitPrice(updatedProduct.getUnitPrice());
		}

		if (null != updatedProduct.getPrice()) {
			product.setPrice(updatedProduct.getPrice());
		}

		if (null != updatedProduct.getRemark()) {
			product.setRemark(updatedProduct.getRemark());
		}

		if (null != updatedProduct.getTotalSaleAmount()) {
			product.setTotalSaleAmount(updatedProduct.getTotalSaleAmount());
		}

		if (null != updatedProduct.getQuantitySold()) {
			product.setQuantitySold(updatedProduct.getQuantitySold());
		}

		if (null != updatedProduct.getQuantityLeft()) {
			product.setQuantityLeft(updatedProduct.getQuantityLeft());
		}

		if (null != updatedProduct.getSalesRevenue()) {
			product.setSalesRevenue(updatedProduct.getSalesRevenue());
		}

		if (null != updatedProduct.getLastSaleDate()) {
			product.setLastSaleDate(updatedProduct.getLastSaleDate());
		}

		product.setUpdatedDate(LocalDateTime.now());
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(String productId) {
		productRepository.deleteById(productId);
	}

}
