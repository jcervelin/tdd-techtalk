package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
@Service
public class ConversorDuracao implements Regra{

    private static final String MSG_ERRO = "Numero invalido [%s]";

    public String executar(String request) {

        final int minutos;

        try {
            minutos = Integer.parseInt(request);
        } catch (NumberFormatException e) {
            throw new ParametroInvalidoException(String.format(MSG_ERRO, request));
        }
        return LocalTime.MIN.plusMinutes(minutos).toString();
    }

    @Override
    public void executar(PerfilCandidato candidato, NovoPerfilCandidato novoPerfilCandidato) {

    }
}
