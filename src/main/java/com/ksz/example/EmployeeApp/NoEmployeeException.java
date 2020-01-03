package com.ksz.example.EmployeeApp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoEmployeeException extends RuntimeException {
    public NoEmployeeException (long id) {
        super("Colleague" + id + "Does not Exist");
    }
}
