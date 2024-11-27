package com.company.project.register.product.application.usecases.find;

import com.company.project.register.product.infrastructure.ProductRepository;
import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.find.FindProductByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindProductByIdUseCaseImpl implements FindProductByIdUseCase {

    private ProductRepository repository;

    @Autowired
    public FindProductByIdUseCaseImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> execute(UUID id) {
        return repository.findById(id);
    }

}