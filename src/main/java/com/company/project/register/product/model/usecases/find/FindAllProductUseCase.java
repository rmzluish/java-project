package com.company.project.register.product.model.usecases.find;

import com.company.project.register.product.model.Product;

import java.util.List;

public interface FindAllProductUseCase {
    List<Product> execute();
}
