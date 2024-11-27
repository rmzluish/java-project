package com.company.project.register.product.infrastructure.controllers;

import com.company.project.register.brand.domain.exceptions.BrandNotFoundException;
import com.company.project.register.product.application.CreateProductService;
import com.company.project.register.product.application.request.CreateProductRequest;
import com.company.project.register.product.application.response.CreateProductResponse;
import com.company.project.shared.application.response.ResponseEntityCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api")
public class CreateProductController {

    private CreateProductService createProductService;

    @Autowired
    public CreateProductController(CreateProductService createProductService) {
        this.createProductService = createProductService;
    }

//    @ResponseStatus(CREATED)
    @PostMapping("/product")
    public ResponseEntityCreate<CreateProductResponse> create(@RequestBody CreateProductRequest request) {
        CreateProductResponse  r = createProductService.execute(request);
        return new ResponseEntityCreate(r);
    }

}
