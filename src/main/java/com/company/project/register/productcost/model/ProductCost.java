package com.company.project.register.productcost.model;

import com.company.project.register.product.model.Product;
import com.company.project.register.supplierproduct.model.SupplierProduct;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class ProductCost {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @OneToOne
    private Product product;

    @OneToOne
    private SupplierProduct supplierProduct;

    private double baseCost;

    private double cost;

    private double profit_percentage;

    private boolean isActive = true;

    public ProductCost() {
    }

    public ProductCost(double baseCost, double cost, double profit_percentage) {
        this.baseCost = baseCost;
        this.cost = cost;
        this.profit_percentage = profit_percentage;
    }

}
