package com.company.project.register.supplier.application.validation;

import com.company.project.register.supplier.model.usecases.exists.ExistsSupplierIdUseCase;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class ExistsSupplierIdValidationCheck implements ConstraintValidator<ExistsSupplierIdValidation, UUID> {

    private ExistsSupplierIdUseCase existsSupplierIdUseCase;

    @Autowired
    public ExistsSupplierIdValidationCheck(ExistsSupplierIdUseCase existsSupplierIdUseCase) {
        this.existsSupplierIdUseCase = existsSupplierIdUseCase;
    }

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return existsSupplierIdUseCase.execute(value);
    }

}
