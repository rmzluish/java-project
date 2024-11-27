package com.company.project.register.supplier.infrastructure.controllers;

import com.company.project.register.supplier.model.Supplier;
import com.company.project.register.supplier.model.usecases.find.FindSupplierByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/supplier")
public class GetSupplierController {

    private FindSupplierByIdUseCase findSupplierByIdUseCase;

    @Autowired
    public GetSupplierController(FindSupplierByIdUseCase findSupplierByIdUseCase) {
        this.findSupplierByIdUseCase = findSupplierByIdUseCase;
    }

    @GetMapping("/{id}")
    public Supplier execute(@PathVariable("id") String id){
        return findSupplierByIdUseCase.execute( UUID.fromString(id) );
    }

}
