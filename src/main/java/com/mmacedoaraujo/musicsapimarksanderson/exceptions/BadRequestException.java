package com.mmacedoaraujo.musicsapimarksanderson.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3463292303579415929L;

    public BadRequestException(String msg) {
        super(msg);
    }
}
