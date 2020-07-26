package com.github.fabriciolfj.cadastropessoa.api.exceptions;

import com.github.fabriciolfj.cadastropessoa.domain.entity.Logradouro;

public class LogradouroException extends RuntimeException {

    public LogradouroException(final String msg) {
        super(msg);
    }

    public LogradouroException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
