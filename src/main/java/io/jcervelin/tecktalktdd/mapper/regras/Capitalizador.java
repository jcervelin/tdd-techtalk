package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Capitalizador implements Regra {

    private static final String NOME_E_OBRIGATORIO = "Nome é obrigatório";

    public String executar(String request) {

        if (!StringUtils.hasText(request)) {
            throw new ParametroInvalidoException(NOME_E_OBRIGATORIO);
        }

        // regex de espacos em branco \b
        return Stream.of(request.split(" "))
                .map(palavra -> palavra.substring(0,1).toUpperCase()
                        .concat(palavra.substring(1).toLowerCase())
                ).collect(Collectors.joining(" "));
    }


    @Override
    public void executar(PerfilCandidato candidato, NovoPerfilCandidato novoPerfilCandidato) {
        final String novoNome = this.executar(candidato.getNome());
        novoPerfilCandidato.setNome(novoNome);
    }
}
