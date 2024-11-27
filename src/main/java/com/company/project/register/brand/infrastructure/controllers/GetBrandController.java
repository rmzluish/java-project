package com.company.project.register.brand.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GetBrandController {

    @GetMapping("/brand")
    public ResponseEntity<String> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
