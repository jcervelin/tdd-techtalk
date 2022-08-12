package io.jcervelin.tecktalktdd.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import io.jcervelin.tecktalktdd.mapper.regras.Capitalizador;
import io.jcervelin.tecktalktdd.mapper.regras.ConversorDuracao;
import io.jcervelin.tecktalktdd.mapper.regras.TruncadorDescricao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NovaPlataformaMapperServiceImplTest {

    private NovaPlataformaMapperServiceImpl alvo;

    @BeforeEach
    public void setup() {
        alvo = new NovaPlataformaMapperServiceImpl(new ObjectMapper(), new Capitalizador(),
                new ConversorDuracao(), new TruncadorDescricao());
    }

    @Test
    public void deveConverter() {
        String request = "{\n" +
                "  \"nome\": \"joao da silva\",\n" +
                "  \"duracaoEmMinutos\": 60,\n" +
                "  \"descricao\": \"O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar\",\n" +
                "  \"dataInicio\": \"2022-07-20\",\n" +
                "  \"horaInicio\": \"13:00\",\n" +
                "  \"dataFim\": \"2022-07-20\",\n" +
                "  \"horaFim\": \"13:30\"\n" +
                "}\n";

        String retorno = alvo.mapMetadata(request);

        String esperado = "{\"nome\":\"joao da silva\",\"duracaoEmMinutos\":\"01:30\",\"descricao\":\"O candidato Savio se mostrou apreensivo ao ser perguntado sobre seu histórico..\",\"dataInicio\":\"2022-07-20T13:00\",\"dataFim\":\"2022-07-20T13:30\"}";

        Assertions.assertEquals(esperado, retorno);
    }
}