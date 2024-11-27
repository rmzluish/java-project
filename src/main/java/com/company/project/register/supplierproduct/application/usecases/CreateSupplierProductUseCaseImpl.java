package com.company.project.register.supplierproduct.application.usecases;

import com.company.project.register.supplierproduct.infrastructure.SupplierProductRepository;
import com.company.project.register.supplierproduct.model.SupplierProduct;
import com.company.project.register.supplierproduct.model.usecases.CreateSupplierProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplierProductUseCaseImpl implements CreateSupplierProductUseCase {

    private SupplierProductRepository repository;

    @Autowired
    public CreateSupplierProductUseCaseImpl(SupplierProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplierProduct execute(SupplierProduct supplierProduct) {
        return repository.save(supplierProduct);
    }

}
