package com.company.project.register.product.application.mapper;

import com.company.project.register.brand.domain.Brand;
import com.company.project.register.brand.domain.exceptions.BrandNotFoundException;
import com.company.project.register.brand.domain.usecases.FindBrandByIdUseCase;
import com.company.project.register.product.application.request.CreateProductRequest;
import com.company.project.register.product.application.response.CreateProductResponse;
import com.company.project.register.product.model.Product;
import com.company.project.shared.model.exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CreateProductMapper {

    private final FindBrandByIdUseCase findBrandByIdUseCase;

    @Autowired
    public CreateProductMapper(FindBrandByIdUseCase findBrandByIdUseCase) {
        this.findBrandByIdUseCase = findBrandByIdUseCase;
    }

    public Product toEntity(CreateProductRequest request) {
        Product product;
        try {
            Brand brand = findBrandByIdUseCase.execute(request.getBrandId());
            product = new Product(request.getUpc(),
                    request.getSku(),
                    request.getPartNumber(),
                    request.getSat_code()
            );
            product.setBrand(brand);
        }
        catch (BrandNotFoundException ex){
            throw new UnprocessableEntityException(ex.getMessage());
        }
        return product;
    }

    public CreateProductResponse toResponse(Product product) {
        CreateProductResponse response = new CreateProductResponse();
        response.setPartNumber(product.getPartNumber());
        response.setUpc(product.getUpc());
        return response;
    }
}
