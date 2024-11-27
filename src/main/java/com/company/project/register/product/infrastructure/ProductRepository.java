package com.company.project.register.product.infrastructure;

import com.company.project.register.product.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
//    @Query("SELECT p FROM Product p WHERE p.name = ?1")
//    Optional<Product> findByName(String name);
    List<Product> findAll();
    Optional<Product> findByUpc(String upc);
    Optional<Product> findByPartNumber(String partNumber);
}
