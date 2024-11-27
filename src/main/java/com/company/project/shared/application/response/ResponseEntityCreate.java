package com.company.project.shared.application.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityCreate<T> extends ResponseEntity<T> {
    public ResponseEntityCreate(T body) {
        super(body, HttpStatus.CREATED);
    }

    public ResponseEntityCreate(T body, HttpStatus status) {
        super(body, status);
    }
}
