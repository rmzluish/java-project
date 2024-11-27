package com.company.project.register.supplierproduct.application.request;

import com.company.project.register.supplier.application.validation.ExistsSupplierIdValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.UUID;

@Data
public class CreateSupplierProductRequest {

    @ExistsSupplierIdValidation
    @JsonProperty("supplier_id")
    private UUID supplierId;

    @NotNull(message = "The name cannot be null")
    @Size(min = 2, max = 100, message = "Product name must be between {min} and {max} characters long")
    private String name;

    public CreateSupplierProductRequest() {
    }

    public CreateSupplierProductRequest(String name, UUID supplierId) {
        this.name = name;
        this.supplierId = supplierId;
    }

}