package com.company.project.register.supplier.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Supplier {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean isActive = true;

    public Supplier() {
    }

    public Supplier(String name) {
        this.name = name;
    }
}
