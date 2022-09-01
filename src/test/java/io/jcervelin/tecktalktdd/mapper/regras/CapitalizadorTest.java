package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import io.jcervelin.tecktalktdd.mapper.regras.Capitalizador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CapitalizadorTest {

    private static final String MSG_NOME = "Nome é obrigatório";
    private Capitalizador target;

    @Test
    public void deveCapitalizarNome() {
        String request = "joao da silva";
        String esperado = "Joao Da Silva";

        target = new Capitalizador();
        String retorno = target.executar(request);

        Assertions.assertEquals(esperado, retorno);
    }

    @Test
    public void nomeNaoDeveSerNulo() {
        String request = null;

        target = new Capitalizador();

        final ParametroInvalidoException retorno = Assertions.assertThrows(ParametroInvalidoException.class,
                () -> target.executar(request));

        Assertions.assertEquals(MSG_NOME, retorno.getMessage());
    }

    @Test
    public void nomeNaoDeveTerEspacoEmBranco() {
        String request = "     ";

        target = new Capitalizador();

        final ParametroInvalidoException retorno = Assertions.assertThrows(ParametroInvalidoException.class,
                () -> target.executar(request));

        Assertions.assertEquals(MSG_NOME, retorno.getMessage());
    }

}