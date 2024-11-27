package com.company.project.register.role.application.usecases.find;

import com.company.project.register.role.infrastructure.RoleRepository;
import com.company.project.register.role.model.Role;
import com.company.project.register.role.model.usecases.find.FindRoleByNameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindRoleByNameUseCaseImpl implements FindRoleByNameUseCase {

    private RoleRepository repository;

    @Autowired
    public FindRoleByNameUseCaseImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Role> execute(String name) {
        return repository.findByName(name);
    }

}
