package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CapitalizadorTest {

    private Capitalizador alvo;

    @BeforeEach
    public void setup() {
        alvo = new Capitalizador();
    }

    @Test
    @DisplayName("Deve retornar iniciais em maiúsculo")
    public void deveRetornarIniciaisMaiusculas() {
        String request = "joao da silva";
        String esperado = "Joao Da Silva";

        String retorno = alvo.capitalizar(request);

        Assertions.assertEquals(esperado, retorno);
    }

    @Test
    public void deveLidarComNomesEmMaiusculo() {
        String request = "joAo da silva";
        String esperado = "Joao Da Silva";

        String retorno = alvo.capitalizar(request);

        Assertions.assertEquals(esperado, retorno);
    }

    @Test
    public void deveRetornarExceptionSeNomeVazioOuNulo() {
        String request = null;

        String msgEsperada = "Nome é obrigatorio";
        ParametroInvalidoException retorno = Assertions.assertThrows(ParametroInvalidoException.class,
                () -> alvo.capitalizar(request));

        Assertions.assertEquals(msgEsperada, retorno.getMessage());
    }
}