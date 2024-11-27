package com.company.project.register.brand.infrastructure;

import com.company.project.register.brand.domain.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BrandRepository extends CrudRepository<Brand, UUID> {
}
