package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;

public interface RegraMapeamento {

    void executar(PerfilCandidato candidato, NovoPerfilCandidato novoPerfilCandidato);

    String executar(String valor);

}
