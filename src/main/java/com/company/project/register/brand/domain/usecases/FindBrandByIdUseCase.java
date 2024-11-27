package com.company.project.register.brand.domain.usecases;

import com.company.project.register.brand.domain.Brand;

import java.util.UUID;

public interface FindBrandByIdUseCase {
    Brand execute(UUID id);
}
