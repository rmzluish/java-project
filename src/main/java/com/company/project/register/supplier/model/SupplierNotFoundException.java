package com.company.project.register.supplier.model;

import com.company.project.shared.model.exceptions.NotFoundException;

public class SupplierNotFoundException extends NotFoundException {
    public SupplierNotFoundException(String message) {
        super(message);
    }
}
