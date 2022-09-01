package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import org.springframework.stereotype.Service;

@Service
public class TruncadorDescricao implements Regra {

    public String executar(String request) {
        return null;
    }

    @Override
    public void executar(PerfilCandidato candidato, NovoPerfilCandidato novoPerfilCandidato) {

    }
}
