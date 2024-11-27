package com.company.project.register.supplier.infrastructure;

import com.company.project.register.supplier.model.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SupplierRepository extends CrudRepository<Supplier, UUID> {
}
