package com.company.project.register.product.model.usecases;

import com.company.project.register.product.model.Product;

public interface CreateProductUseCase {
    Product save(Product product);
}
