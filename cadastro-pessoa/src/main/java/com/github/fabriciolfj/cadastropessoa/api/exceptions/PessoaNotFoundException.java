package com.github.fabriciolfj.cadastropessoa.api.exceptions;

public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    public PessoaNotFoundException(final String msg) {
        super(msg);
    }
}
