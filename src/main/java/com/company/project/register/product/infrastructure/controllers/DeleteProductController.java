package com.company.project.register.product.infrastructure.controllers;

import com.company.project.register.product.application.DeleteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api")
@RestController
public class DeleteProductController {

    private DeleteProductService deleteProductService;

    @Autowired
    public DeleteProductController(DeleteProductService deleteProductService) {
        this.deleteProductService = deleteProductService;
    }

    @DeleteMapping("/product/{id}")
    void delete(@PathVariable("id") UUID id){
        deleteProductService.execute(id);
    }

}
