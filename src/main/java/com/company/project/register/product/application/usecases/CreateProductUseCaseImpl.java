package com.company.project.register.product.application.usecases;

import com.company.project.register.product.infrastructure.ProductRepository;
import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.CreateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepository repository;

    @Autowired
    public CreateProductUseCaseImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return repository.save(product);
    }

}