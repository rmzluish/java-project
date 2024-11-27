package com.company.project.register.user.model.usecases;

import com.company.project.register.user.model.User;

import java.util.List;

public interface FindAllUserUseCase {
    List<User> execute();
}
