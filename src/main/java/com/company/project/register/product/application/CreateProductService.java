package com.company.project.register.product.application;

import com.company.project.register.brand.domain.exceptions.BrandNotFoundException;
import com.company.project.register.product.application.mapper.CreateProductMapper;
import com.company.project.register.product.application.request.CreateProductRequest;
import com.company.project.register.product.application.response.CreateProductResponse;
import com.company.project.register.product.model.Product;
import com.company.project.register.product.model.usecases.CreateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CreateProductService {

    private final CreateProductUseCase createProductUseCase;
    private final CreateProductMapper createProductMapper;

    @Autowired
    public CreateProductService(
            CreateProductUseCase createProductUseCase,
            CreateProductMapper createProductMapper
    ) {
        this.createProductUseCase = createProductUseCase;
        this.createProductMapper = createProductMapper;
    }

    public CreateProductResponse execute(CreateProductRequest request) {
        Product product = createProductMapper.toEntity(request);
        Product savedProduct = createProductUseCase.save(product);
        return createProductMapper.toResponse(savedProduct);
    }

}
