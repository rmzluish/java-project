package com.company.project.register.supplierproduct.model;

import com.company.project.register.supplier.model.Supplier;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class SupplierProduct {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    public SupplierProduct() {
    }

    public SupplierProduct(String name) {
        this.name = name;
    }

}