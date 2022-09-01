package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class ConversorDuracaoTest {

    @InjectMocks
    private ConversorDuracao target;

    @Test
    public void deveConverterQtdMinutosParaHoras() {
        String request = "90";
        String esperado = "01:30";

        String retorno = target.executar(request);
        assertEquals(esperado, retorno);
    }

    @Test
    public void deveRetornarExcecaoSeNumeroInvalido() {
        String request = "banana";

        String msgErro = "Numero invalido [banana]";

        final ParametroInvalidoException retorno = assertThrows(ParametroInvalidoException.class,
                () -> target.executar(request));

        assertEquals(msgErro, retorno.getMessage());
    }

}