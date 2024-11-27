package com.company.project.register.product.application.usecases.find;

import com.company.project.register.product.infrastructure.ProductRepository;
import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.find.FindAllProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProductUseCaseImpl implements FindAllProductUseCase {

    private ProductRepository repository;

    @Autowired
    public FindAllProductUseCaseImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> execute() {
        return (List<Product>) repository.findAll();
    }
}
