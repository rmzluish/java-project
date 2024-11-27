package com.company.project.register.user.model.usecases;

import com.company.project.register.user.model.User;

public interface CreateUserUseCase {
    User execute(User user);
}
