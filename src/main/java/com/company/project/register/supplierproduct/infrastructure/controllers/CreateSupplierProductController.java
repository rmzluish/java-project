package com.company.project.register.supplierproduct.infrastructure.controllers;

import com.company.project.register.supplierproduct.application.CreateSupplierProductService;
import com.company.project.register.supplierproduct.application.request.CreateSupplierProductRequest;
import com.company.project.register.supplierproduct.application.response.CreateSupplierProductResponse;
import com.company.project.shared.application.response.ResponseEntityCreate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/supplier/product")
public class CreateSupplierProductController {

    private final View error;
    CreateSupplierProductService createSupplierProductService;

    @Autowired
    public CreateSupplierProductController(CreateSupplierProductService createSupplierProductService, View error) {
        this.createSupplierProductService = createSupplierProductService;
        this.error = error;
    }

    @PostMapping("")
    public ResponseEntityCreate<CreateSupplierProductResponse> execute(@Valid @RequestBody CreateSupplierProductRequest request, BindingResult result){
        if(result.hasFieldErrors()){
            return validation(result);
        }
        CreateSupplierProductResponse r = createSupplierProductService.execute(request);
        return new ResponseEntityCreate(r);
    }

    private ResponseEntityCreate<CreateSupplierProductResponse> validation(BindingResult result) {

        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(toSnakeCase(err.getField()), " * The field: " + toSnakeCase(err.getField()) + " " + err.getDefaultMessage());
        });

        return new  ResponseEntityCreate( errors, HttpStatus.BAD_REQUEST);

    }


    public static String toSnakeCase(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append("_").append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
