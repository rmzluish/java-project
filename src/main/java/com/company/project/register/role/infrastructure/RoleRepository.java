package com.company.project.register.role.infrastructure;

import com.company.project.register.role.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {

    Optional<Role> findByName(String name);

}
