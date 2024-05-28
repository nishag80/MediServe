package com.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.entity.Product;
import com.edu.exception.SystemException;

@Service
public interface ProductService {

	public Product createProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProduct(String productId) throws SystemException;

	public Product updateProduct(String productId, Product updatedProduct) throws SystemException;

	public void deleteProduct(String productId);

	
}
