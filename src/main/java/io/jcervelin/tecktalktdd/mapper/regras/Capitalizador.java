package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Capitalizador implements RegraMapeamento{
    private static final String NOME_OBRIGATORIO = "Nome é obrigatorio";

    @Override
    public void executar(PerfilCandidato candidato, NovoPerfilCandidato novoPerfilCandidato) {
        final String novoNome = this.executar(candidato.getNome());
        novoPerfilCandidato.setNome(novoNome);
    }

    public String executar(String request) {

        if (!StringUtils.hasLength(request)) {
            throw new ParametroInvalidoException(NOME_OBRIGATORIO);
        }

        return Stream.of(request.toLowerCase().split(" "))
                .map(palavra -> palavra.substring(0,1).toUpperCase()
                        .concat(palavra.substring(1)))
                .collect(Collectors.joining(" "));
    }
}
