package com.company.project.register.product.application.usecases;

import com.company.project.register.product.infrastructure.ProductRepository;
import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.DeleteProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private ProductRepository repository;

    @Autowired
    public DeleteProductUseCaseImpl(ProductRepository repository) {
        this.repository = repository;
    }
 
    @Override
    public void execute(Product product) {
        repository.delete(product);
    }

}
