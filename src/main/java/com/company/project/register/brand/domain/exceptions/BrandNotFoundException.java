package com.company.project.register.brand.domain.exceptions;

import com.company.project.shared.model.exceptions.NotFoundException;

public class BrandNotFoundException extends NotFoundException {
    public BrandNotFoundException(String message) {
        super(message);
    }
}
