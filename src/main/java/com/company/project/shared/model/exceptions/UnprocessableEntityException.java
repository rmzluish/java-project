package com.company.project.shared.model.exceptions;

import com.company.project.shared.model.ErrorException;

public class UnprocessableEntityException extends RuntimeException {
    public UnprocessableEntityException(String message) {
        super(message);
    }
}
