package com.company.project.register.supplierproduct.application.response;

import com.company.project.register.supplier.model.Supplier;
import lombok.Data;

@Data
public class CreateSupplierProductResponse {

    private Supplier supplier;

    private String name;

}
