package com.company.project.register.supplier.application.usecases.find;

import com.company.project.register.supplier.infrastructure.SupplierRepository;
import com.company.project.register.supplier.model.Supplier;
import com.company.project.register.supplier.model.SupplierNotFoundException;
import com.company.project.register.supplier.model.usecases.find.FindSupplierByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class FindSupplierByIdUseCaseImpl implements FindSupplierByIdUseCase {

    private SupplierRepository repository;

    @Autowired
    public FindSupplierByIdUseCaseImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public Supplier execute(UUID id) {
        return repository.findById(id)
                    .orElseThrow(()-> new SupplierNotFoundException("Supplier selected not exists"));
    }
}
