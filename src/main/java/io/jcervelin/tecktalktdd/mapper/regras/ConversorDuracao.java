package io.jcervelin.tecktalktdd.mapper.regras;


import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;

import java.time.Duration;
import java.time.LocalTime;

public class ConversorDuracao implements RegraMapeamento{
    @Override
    public void executar(PerfilCandidato candidato, NovoPerfilCandidato novoPerfilCandidato) {
        final String novaDuracao = this.executar(candidato.getDuracaoEmMinutos());
        novoPerfilCandidato.setDuracao(novaDuracao);
    }

    public String executar(String request) {
        final int minutos;
        try {
            minutos = Integer.parseInt(request);
        } catch (NumberFormatException e) {
            throw new ParametroInvalidoException(String.format("Numero invalido [%s]",request));
        }
        return LocalTime.MIN.plus(Duration.ofMinutes(minutos)).toString();
    }
}
