package io.jcervelin.tecktalktdd.exceptions;

public class ParametroInvalidoException extends RuntimeException {
    public ParametroInvalidoException(String nomeObrigatorio) {
        super(nomeObrigatorio);
    }
}
