package com.company.project.register.user.infrastructure.controllers;

import com.company.project.register.user.model.User;
import com.company.project.register.user.model.usecases.CreateUserUseCase;
import com.company.project.register.user.model.usecases.FindAllUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private FindAllUserUseCase findAllUserUseCase;
    private CreateUserUseCase createUserUseCase;

    @Autowired
    public UserController(FindAllUserUseCase findAllUserUseCase, CreateUserUseCase createUserUseCase) {
        this.findAllUserUseCase = findAllUserUseCase;
        this.createUserUseCase = createUserUseCase;
    }

    @GetMapping()
    public List<User> list(){
        return findAllUserUseCase.execute();
    }

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user){
        return  ResponseEntity.status(HttpStatus.CREATED).body(createUserUseCase.execute(user));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        user.setAdmin(false);
        return  create(user);
    }


}
