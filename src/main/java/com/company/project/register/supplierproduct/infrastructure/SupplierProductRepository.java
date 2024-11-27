package com.company.project.register.supplierproduct.infrastructure;

import com.company.project.register.supplierproduct.model.SupplierProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SupplierProductRepository extends CrudRepository<SupplierProduct, UUID> {
}
