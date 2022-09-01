package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;

public class TruncadorDescricao implements RegraMapeamento {

    private static final int MAX_TAMANHO_DESCRICAO = 80;

    private static final String SUFIXO_DESCRICAO = "..";

    @Override
    public void executar(PerfilCandidato candidato, NovoPerfilCandidato novoPerfilCandidato) {
        final String novaDescricao = this.executar(candidato.getDescricao());
        novoPerfilCandidato.setDescricao(novaDescricao);
    }

    public String executar(String request) {

        if (request.length() > MAX_TAMANHO_DESCRICAO) {
            return request.substring(0,MAX_TAMANHO_DESCRICAO - SUFIXO_DESCRICAO.length()).concat(SUFIXO_DESCRICAO);
        }
        return request;
    }
}
