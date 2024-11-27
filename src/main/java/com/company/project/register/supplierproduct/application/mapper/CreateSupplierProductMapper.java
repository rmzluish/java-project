package com.company.project.register.supplierproduct.application.mapper;

import com.company.project.register.product.application.response.CreateProductResponse;
import com.company.project.register.supplier.model.Supplier;
import com.company.project.register.supplier.model.SupplierNotFoundException;
import com.company.project.register.supplier.model.usecases.find.FindSupplierByIdUseCase;
import com.company.project.register.supplierproduct.application.request.CreateSupplierProductRequest;
import com.company.project.register.supplierproduct.application.response.CreateSupplierProductResponse;
import com.company.project.register.supplierproduct.model.SupplierProduct;
import com.company.project.shared.model.exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplierProductMapper {

    private FindSupplierByIdUseCase  findSupplierByIdUseCase;

    @Autowired
    public CreateSupplierProductMapper(FindSupplierByIdUseCase findSupplierByIdUseCase) {
        this.findSupplierByIdUseCase = findSupplierByIdUseCase;
    }

    public SupplierProduct toEntity(CreateSupplierProductRequest request){
        SupplierProduct supplierProduct = null;
        try{
            Supplier supplier = findSupplierByIdUseCase.execute(request.getSupplierId());
            supplierProduct = new SupplierProduct(request.getName());
            supplierProduct.setSupplier(supplier);
        }
        catch (SupplierNotFoundException ex){
            throw new UnprocessableEntityException(ex.getMessage());
        }
        return supplierProduct;
    }

    public CreateSupplierProductResponse toResponse(SupplierProduct supplierProduct){
        CreateSupplierProductResponse response = new CreateSupplierProductResponse();
        response.setSupplier(supplierProduct.getSupplier());
        response.setName(supplierProduct.getName());
        return response;
    }

}