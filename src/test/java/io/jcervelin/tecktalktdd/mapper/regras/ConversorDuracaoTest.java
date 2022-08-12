package io.jcervelin.tecktalktdd.mapper.regras;

import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ConversorDuracaoTest {

    @InjectMocks
    private ConversorDuracao alvo;

    @Test
    public void deveConverterQtdMinutosParaHoras() {
        String request = "90";
        LocalTime esperado = LocalTime.of(1,30);

        LocalTime retorno = alvo.converter(request);

        assertThat(retorno).isEqualTo(esperado);
    }

    @Test
    public void deveRetornarExcecaoSeNumeroInvalido() {
        String request = "banana de pijama";

        String erroEsperado = "Numero invalido [banana de pijama]";
        final ParametroInvalidoException parametroInvalidoException = org.junit.jupiter.api.Assertions.assertThrows(ParametroInvalidoException.class,
                () -> alvo.converter(request));

        assertThat(parametroInvalidoException.getMessage()).isEqualTo(erroEsperado);
    }
}