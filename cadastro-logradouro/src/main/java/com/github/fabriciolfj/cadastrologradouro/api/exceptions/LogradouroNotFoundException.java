package com.github.fabriciolfj.cadastrologradouro.api.exceptions;

public class LogradouroNotFoundException extends RuntimeException {

    public LogradouroNotFoundException(final String msg) {
        super(msg);
    }

    public LogradouroNotFoundException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
