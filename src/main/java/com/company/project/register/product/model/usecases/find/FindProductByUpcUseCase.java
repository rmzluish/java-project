package com.company.project.register.product.model.usecases.find;

import com.company.project.register.product.model.Product;

import java.util.Optional;

public interface FindProductByUpcUseCase {
    Product execute(String upc);
}
