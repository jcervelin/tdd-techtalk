package io.jcervelin.tecktalktdd.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import io.jcervelin.tecktalktdd.exceptions.ParametroInvalidoException;
import io.jcervelin.tecktalktdd.mapper.regras.Capitalizador;
import io.jcervelin.tecktalktdd.mapper.regras.ConversorDuracao;
import io.jcervelin.tecktalktdd.mapper.regras.TruncadorDescricao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NovaPlataformaMapperServiceTest {

    @Spy
    private ObjectMapper objectMapper;

    @Mock
    private Capitalizador capitalizador;
    @Mock
    private ConversorDuracao conversorDuracao;

    @Mock
    private TruncadorDescricao truncadorDescricao;

    private NovaPlataformaMapperServiceImpl target;

    @BeforeEach
    public void setup() {
        target = new NovaPlataformaMapperServiceImpl(
                objectMapper, List.of(capitalizador, conversorDuracao, truncadorDescricao));
    }

//    @Test
//    void mapMetadataDeveLancarErroWhenEntradaNula() {
//        Assertions.assertThrows(ParametroInvalidoException.class, () -> target.mapMetadata());
//    }

    @Test
    void mapMetadataDeveRetornarValorComSucesso() throws JsonProcessingException {
        String request = "{\n" +
                "  \"nome\": \"joao da silva\",\n" +
                "  \"duracaoEmMinutos\": 60,\n" +
                "  \"descricao\": \"O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar\",\n" +
                "  \"dataInicio\": \"2022-07-20\",\n" +
                "  \"horaInicio\": \"13:00\",\n" +
                "  \"dataFim\": \"2022-07-20\",\n" +
                "  \"horaFim\": \"13:30\"\n" +
                "}\n";

        when(capitalizador.executar("joao da silva"))
                .thenReturn("Joao Da Silva");

        when(conversorDuracao.executar("60"))
                .thenReturn("01:30");

        when(truncadorDescricao.executar("O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar"))
                .thenReturn("Deu certo");

        final String retorno = target.mapMetadata(request);

        String esperado = "{\"nome\":\"Joao Da Silva\",\"duracao\":\"01:30\",\"descricao\":\"O candidato Savio se mostrou apreensivo ao ser perguntado sobre seu histórico..\",\"dataInicio\":\"2022-07-20T13:00\",\"dataFim\":\"2022-07-20T13:30\"}";
       // Assertions.assertEquals(esperado, retorno);

        Mockito.verify(objectMapper).readValue(esperado, PerfilCandidato.class);
    }


}