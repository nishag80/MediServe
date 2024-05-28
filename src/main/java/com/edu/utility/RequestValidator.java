package com.edu.utility;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.edu.entity.Customer;
import com.edu.entity.Medicine;
import com.edu.exception.MissingParameterException;

@Component
public class RequestValidator {
	
    public void validateMedicineRequest(Medicine request) {
        if (StringUtils.isNotBlank(request.getName())) {
            throw new MissingParameterException("name");
        }
        if (StringUtils.isNotBlank(request.getDescription())) {
            throw new MissingParameterException("description");
        }
        if (request.getPrice() == null ) {
            throw new MissingParameterException("price");
        }
//        if (request.getAnalytics() == null || request.getAnalytics().getQuantityLeft() <= 0) {
//            throw new IllegalArgumentException("quantityLeft must be provided and greater than 0");
//        }
    }

    public void validateCustomerRequest(Customer request) {
        if (StringUtils.isNotBlank(request.getName())) {
            throw new MissingParameterException("name");
        }
        if (StringUtils.isNotBlank(request.getPhoneNumbers())) {
            throw new MissingParameterException("PhoneNumber");
        }
    }

}
