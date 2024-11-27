package com.company.project.register.product.infrastructure.controllers;

import com.company.project.register.product.application.UpdateProductService;
import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.find.FindProductByIdUseCase;
import com.company.project.register.product.model.usecases.UpdateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UpdateProductController {

    private UpdateProductService updateProductService;

    @Autowired
    public UpdateProductController(UpdateProductService updateProductService) {
        this.updateProductService = updateProductService;
    }

    @PutMapping("/product/{id}")
    Product  update(@PathVariable("id") UUID id){
        return updateProductService.execute(id);
    }

}
