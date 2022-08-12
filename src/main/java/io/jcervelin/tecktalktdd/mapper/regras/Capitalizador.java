package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Capitalizador {
    private static final String NOME_OBRIGATORIO = "Nome é obrigatorio";

    public String capitalizar(String request) {

        if (!StringUtils.hasLength(request)) {
            throw new ParametroInvalidoException(NOME_OBRIGATORIO);
        }

        return Stream.of(request.toLowerCase().split(" "))
                .map(palavra -> palavra.substring(0,1).toUpperCase()
                        .concat(palavra.substring(1)))
                .collect(Collectors.joining(" "));
    }
}
