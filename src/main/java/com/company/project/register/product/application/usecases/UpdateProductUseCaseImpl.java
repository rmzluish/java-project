package com.company.project.register.product.application.usecases;

import com.company.project.register.product.infrastructure.ProductRepository;
import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.UpdateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private ProductRepository repository;

    @Autowired
    public UpdateProductUseCaseImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product execute(Product product) {
        return repository.save(product);
    }

}
