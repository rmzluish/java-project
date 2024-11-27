package com.company.project.register.supplier.model.usecases.find;

import com.company.project.register.supplier.model.Supplier;

import java.util.UUID;

public interface FindSupplierByIdUseCase {
    Supplier execute(UUID uuid);
}
