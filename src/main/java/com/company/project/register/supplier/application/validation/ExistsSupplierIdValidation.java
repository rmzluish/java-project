package com.company.project.register.supplier.application.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistsSupplierIdValidationCheck.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsSupplierIdValidation {
    String message() default "doesn't exists";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
