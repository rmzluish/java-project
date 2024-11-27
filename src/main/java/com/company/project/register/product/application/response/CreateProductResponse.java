package com.company.project.register.product.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateProductResponse {

    @JsonProperty("part_number")
    private String partNumber;

    private String upc;
}
