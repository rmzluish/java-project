package com.company.project.register.supplierproduct.application;

import com.company.project.register.supplier.model.usecases.find.FindSupplierByIdUseCase;
import com.company.project.register.supplierproduct.application.mapper.CreateSupplierProductMapper;
import com.company.project.register.supplierproduct.application.request.CreateSupplierProductRequest;
import com.company.project.register.supplierproduct.application.response.CreateSupplierProductResponse;
import com.company.project.register.supplierproduct.model.SupplierProduct;
import com.company.project.register.supplierproduct.model.usecases.CreateSupplierProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplierProductService {

    private CreateSupplierProductMapper createSupplierProductMapper;
    private CreateSupplierProductUseCase createSupplierProductUseCase;

    @Autowired
    public CreateSupplierProductService(CreateSupplierProductMapper createSupplierProductMapper, CreateSupplierProductUseCase createSupplierProductUseCase) {
        this.createSupplierProductMapper = createSupplierProductMapper;
        this.createSupplierProductUseCase = createSupplierProductUseCase;
    }

    public CreateSupplierProductResponse execute(CreateSupplierProductRequest request){
        SupplierProduct supplierProduct = createSupplierProductMapper.toEntity(request);
        SupplierProduct supplierProductSaved = createSupplierProductUseCase.execute(supplierProduct);
        return createSupplierProductMapper.toResponse(supplierProductSaved);
    }

}
