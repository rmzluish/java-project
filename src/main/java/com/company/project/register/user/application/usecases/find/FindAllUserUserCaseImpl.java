package com.company.project.register.user.application.usecases.find;

import com.company.project.register.user.infrastructure.UserRepository;
import com.company.project.register.user.model.User;
import com.company.project.register.user.model.usecases.FindAllUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindAllUserUserCaseImpl implements FindAllUserUseCase {

    private UserRepository repository;

    @Autowired
    public FindAllUserUserCaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> execute() {
        return (List<User>) repository.findAll();
    }

}
