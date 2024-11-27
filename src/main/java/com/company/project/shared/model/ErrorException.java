package com.company.project.shared.model;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorException {
    private String message;
    private String Error;
    private int status;
    private Date date;
}
