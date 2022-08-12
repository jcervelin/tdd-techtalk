package io.jcervelin.tecktalktdd.mapper.regras;

public class TruncadorDescricao {

    private static final int MAX_TAMANHO_DESCRICAO = 80;

    private static final String SUFIXO_DESCRICAO = "..";

    public String truncar(String request) {

        if (request.length() > MAX_TAMANHO_DESCRICAO) {
            return request.substring(0,MAX_TAMANHO_DESCRICAO - SUFIXO_DESCRICAO.length()).concat(SUFIXO_DESCRICAO);
        }
        return request;
    }
}
