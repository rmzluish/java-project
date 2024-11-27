package com.company.project.register.supplier.model.usecases.exists;

import java.util.UUID;

public interface ExistsSupplierIdUseCase {
    boolean execute(UUID id);
}
