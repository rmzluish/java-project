package com.company.project.register.product.application;

import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.DeleteProductUseCase;
import com.company.project.register.product.model.usecases.find.FindProductByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteProductService {
    private FindProductByIdUseCase findProductByIdUseCase;
    private DeleteProductUseCase deleteProductUseCase;

    @Autowired
    public DeleteProductService(DeleteProductUseCase deleteProductUseCase, FindProductByIdUseCase findProductByIdUseCase) {
        this.deleteProductUseCase = deleteProductUseCase;
        this.findProductByIdUseCase = findProductByIdUseCase;
    }

    public void execute(@PathVariable("id") UUID id){

        Optional<Product> optionalProduct = findProductByIdUseCase.execute(id);

        Product product = null;
        if(optionalProduct.isPresent()){
            product = optionalProduct.orElseThrow();
            product.setBrand(null);
            deleteProductUseCase.execute(product);
        }

    }
}
