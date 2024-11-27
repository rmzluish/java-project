package com.company.project.register.brand.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name="brand")
@Data
public class Brand {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean isActive = true;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

}