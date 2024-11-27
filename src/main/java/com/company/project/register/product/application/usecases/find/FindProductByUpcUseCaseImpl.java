package com.company.project.register.product.application.usecases.find;

import com.company.project.register.product.infrastructure.ProductRepository;
import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.find.FindProductByUpcUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class FindProductByUpcUseCaseImpl implements FindProductByUpcUseCase {

    private ProductRepository repository;

    @Autowired
    public FindProductByUpcUseCaseImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product execute(String upc) {
        Optional<Product> optionalProduct = repository.findByUpc(upc);
        Product product = null;
        if(optionalProduct.isPresent()){
            product = optionalProduct.orElseThrow();
        }
        return product;
    }
}
