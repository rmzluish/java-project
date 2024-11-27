package com.company.project.register.role.model.usecases.find;

import com.company.project.register.role.model.Role;

import java.util.Optional;

public interface FindRoleByNameUseCase {
    Optional<Role> execute(String name);
}
