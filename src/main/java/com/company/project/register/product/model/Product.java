package com.company.project.register.product.model;

import com.company.project.register.brand.domain.Brand;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String upc;
    private String partNumber;
    private String sku;
    private String sat_code;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean isActive = true;

    public Product() {}

    public Product(String upc, String sku, String partNumber, String sat_code) {
        this.upc = upc;
        this.sku = sku;
        this.partNumber = partNumber;
        this.sat_code = sat_code;
    }

}
