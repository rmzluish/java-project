package com.company.project.register.product.model.usecases.find;

import com.company.project.register.product.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface FindProductByIdUseCase {
    Optional<Product> execute(UUID id);
}
