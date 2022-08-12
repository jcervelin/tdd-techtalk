package io.jcervelin.tecktalktdd.mapper.regras;


import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;

import java.time.Duration;
import java.time.LocalTime;

public class ConversorDuracao {
    public LocalTime converter(String request) {
        final int minutos;
        try {
            minutos = Integer.parseInt(request);
        } catch (NumberFormatException e) {
            throw new ParametroInvalidoException(String.format("Numero invalido [%s]",request));
        }
        return LocalTime.MIN.plus(Duration.ofMinutes(minutos));
    }
}
