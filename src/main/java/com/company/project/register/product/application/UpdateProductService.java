package com.company.project.register.product.application;

import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.UpdateProductUseCase;
import com.company.project.register.product.model.usecases.find.FindProductByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateProductService {
    private UpdateProductUseCase updateProductUseCase;
    private FindProductByIdUseCase findProductByIdUseCase;

    @Autowired
    public UpdateProductService(FindProductByIdUseCase findProductByIdUseCase, UpdateProductUseCase updateProductUseCase) {
        this.findProductByIdUseCase = findProductByIdUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }

    public Product execute(@PathVariable("id") UUID id){
        Optional<Product> optionalProduct = findProductByIdUseCase.execute(id);
        Product product = null;
        if(optionalProduct.isPresent()){
            product = optionalProduct.orElseThrow();
            product.setPartNumber("This is a new part number");

            updateProductUseCase.execute(product);
        }
        return product;
    }

}
