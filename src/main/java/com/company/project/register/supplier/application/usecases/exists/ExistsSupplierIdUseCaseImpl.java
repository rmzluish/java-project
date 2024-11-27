package com.company.project.register.supplier.application.usecases.exists;

import com.company.project.register.supplier.infrastructure.SupplierRepository;
import com.company.project.register.supplier.model.usecases.exists.ExistsSupplierIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExistsSupplierIdUseCaseImpl implements ExistsSupplierIdUseCase {

    private SupplierRepository repository;

    @Autowired
    public ExistsSupplierIdUseCaseImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean execute(UUID id) {
        return repository.existsById(id);
    }

}