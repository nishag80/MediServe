package com.edu.utility;

import org.springframework.stereotype.Component;

import com.edu.entity.Medicine;
import com.edu.exception.MissingParameterException;

@Component
public class RequestValidator {
	
    public void validateMedicineRequest(Medicine request) {
        if (request.getName() == null) {
            throw new MissingParameterException("name");
        }
        if (request.getDescription() == null) {
            throw new MissingParameterException("description");
        }
        if (request.getPrice() == null) {
            throw new MissingParameterException("price");
        }
//        if (request.getAnalytics() == null || request.getAnalytics().getQuantityLeft() <= 0) {
//            throw new IllegalArgumentException("quantityLeft must be provided and greater than 0");
//        }
    }

}
