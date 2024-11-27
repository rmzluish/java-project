package com.company.project.register.product.application.usecases.find;

import com.company.project.register.product.infrastructure.ProductRepository;
import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.find.FindProductByPartNumberUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindProductByPartNumberUseCaseImpl implements FindProductByPartNumberUseCase {


    private ProductRepository repository;

    @Autowired
    public FindProductByPartNumberUseCaseImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> execute(String partNumber) {
//        return repository.findByName(name);

        return repository.findAll()
                                                .stream()
                                                .filter(e->e.getPartNumber().contains(partNumber))
                                                .findFirst();
/*
        Product product = null;
        if(optionalProduct.isPresent()){
            product = optionalProduct.orElseThrow();
        }

        return product;
*/
    }

}
