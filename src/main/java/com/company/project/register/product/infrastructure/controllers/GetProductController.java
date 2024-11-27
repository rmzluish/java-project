package com.company.project.register.product.infrastructure.controllers;

import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.find.FindAllProductUseCase;
import com.company.project.register.product.model.usecases.find.FindProductByIdUseCase;
import com.company.project.register.product.model.usecases.find.FindProductByUpcUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
public class GetProductController {

    private FindAllProductUseCase findAllProductUseCase;
    private FindProductByIdUseCase findProductByIdUseCase;
    private FindProductByUpcUseCase findProductByUpcUseCase;

    @Autowired
    public GetProductController(
            FindAllProductUseCase findAllProductUseCase,
            FindProductByIdUseCase findProductByIdUseCase,
            FindProductByUpcUseCase findProductByUpcUseCase
    ){
        this.findAllProductUseCase = findAllProductUseCase;
        this.findProductByIdUseCase = findProductByIdUseCase;
        this.findProductByUpcUseCase = findProductByUpcUseCase;
    }

    private final static Pattern UUID_PATTERN = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

    @GetMapping("/products")
    @ResponseStatus(OK)
    public List<Product> getProducts() {
        return findAllProductUseCase.execute();
    }

    @GetMapping("/product/{search}")
    @ResponseStatus(OK)
    public Product getProductById(@PathVariable("search") String search) {
        Product product = null;
        if( UUID_PATTERN.matcher(search).matches() ){
            Optional<Product> optionalProduct = findProductByIdUseCase.execute(UUID.fromString(search));
            if(optionalProduct.isPresent()){
                product = optionalProduct.orElseThrow();
            }
        }
        else{
            product = findProductByUpcUseCase.execute(search);
        }
        return product;
    }

}