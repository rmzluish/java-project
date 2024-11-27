package com.company.project.register.product.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;


@Data
@EqualsAndHashCode
public class CreateProductRequest {

    private String upc;

    @JsonProperty("brand_id")
    private UUID brandId;

    @JsonProperty("part_number")
    private String partNumber;
    private String sku;
    private String sat_code;

    public CreateProductRequest(String upc, String partNumber, String sku, String sat_code, UUID brandId) {
        this.upc = upc;
        this.partNumber = partNumber;
        this.sku = sku;
        this.sat_code = sat_code;
        this.brandId = brandId;
    }

    public CreateProductRequest() {

    }

}