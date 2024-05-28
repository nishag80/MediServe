package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.entity.Product;
import com.edu.exception.SystemException;
import com.edu.service.ProductService;
import com.edu.utility.ApiResponse;
import com.edu.utility.RequestValidator;
import com.edu.utility.StatusType;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private RequestValidator requestValidator;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody Product product) {
		try {
			requestValidator.validateProductRequest(product);
			Product createdProduct = productService.createProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(
					new ApiResponse(StatusType.SUCCESS.getName(), "Product created successfully", createdProduct));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}
	}

	@GetMapping
	public ResponseEntity<ApiResponse> getAllProduct() {
		try {
			List<Product> products = productService.getAllProducts();
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), products));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ApiResponse> getProduct(@PathVariable String productId) throws SystemException {
		try {
			Product product = productService.getProduct(productId);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), product));
		} catch (SystemException e) {
	        throw e;
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<ApiResponse> updateProduct(@RequestBody Product updatedProduct,@PathVariable String productId) throws SystemException {
		try {
			Product updatedProd = productService.updateProduct(productId,updatedProduct);
			
			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(), updatedProd));
		} catch (SystemException e) {
	        throw e;
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}

	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable String productId) {
		try {
			Product product = productService.getProduct(productId);
			productService.deleteProduct(productId);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ApiResponse(StatusType.SUCCESS.getCode(), StatusType.SUCCESS.getDescription(),"Product : " + product.getProductId()
					+ "deleted successfully"));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
		}
	
	}
}
