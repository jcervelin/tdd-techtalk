package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;

public interface Regra {

    void executar(PerfilCandidato candidato, NovoPerfilCandidato novoPerfilCandidato);
}
