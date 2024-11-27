package com.company.project.register.product.model.usecases.find;

import com.company.project.register.product.model.Product;

import java.util.Optional;

public interface FindProductByPartNumberUseCase {
    Optional<Product> execute(String name);
}
