package com.company.project.register.user.application.usecases;

import com.company.project.register.role.model.Role;
import com.company.project.register.role.model.usecases.find.FindRoleByNameUseCase;
import com.company.project.register.user.infrastructure.UserRepository;
import com.company.project.register.user.model.User;
import com.company.project.register.user.model.usecases.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private PasswordEncoder passwordEncoder;
    private UserRepository repository;

    private FindRoleByNameUseCase findRoleByNameUseCase;

    @Autowired
    public CreateUserUseCaseImpl(UserRepository repository, PasswordEncoder passwordEncoder, FindRoleByNameUseCase findRoleByNameUseCase) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.findRoleByNameUseCase = findRoleByNameUseCase;
    }

    @Override
    @Transactional
    public User execute(User user) {

        Optional<Role> optionalRole = findRoleByNameUseCase.execute("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRole.ifPresent(roles::add);

        if( user.isAdmin() ){
            Optional<Role> optionalAdminRole = findRoleByNameUseCase.execute("ROLE_ADMIN");
            optionalAdminRole.ifPresent(roles::add);
        }

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }
}
