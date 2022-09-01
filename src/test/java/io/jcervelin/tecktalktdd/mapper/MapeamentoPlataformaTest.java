package io.jcervelin.tecktalktdd.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import io.jcervelin.tecktalktdd.mapper.regras.Capitalizador;
import io.jcervelin.tecktalktdd.mapper.regras.ConversorDuracao;
import io.jcervelin.tecktalktdd.mapper.regras.TruncadorDescricao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class MapeamentoPlataformaTest {

    @Spy
    private Capitalizador capitalizador;
    @Spy
    private ConversorDuracao conversorDuracao;
    @Spy
    private TruncadorDescricao truncadorDescricao;

    private MapeamentoPlataforma target;

    @Test
    public void shouldApplyAllRules() throws JsonProcessingException {

        target = new MapeamentoPlataforma(List.of(capitalizador, conversorDuracao, truncadorDescricao));

        String request = "{\n" +
                "  \"nome\": \"joao da silva\",\n" +
                "  \"duracaoEmMinutos\": 60,\n" +
                "  \"descricao\": \"O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar\",\n" +
                "  \"dataInicio\": \"2022-07-20\",\n" +
                "  \"horaInicio\": \"13:00\",\n" +
                "  \"dataFim\": \"2022-07-20\",\n" +
                "  \"horaFim\": \"13:30\"\n" +
                "}\n";

        final PerfilCandidato perfilCandidato = new ObjectMapper().readValue(request, PerfilCandidato.class);

        final NovoPerfilCandidato novoPerfilCandidato = target.mapear(perfilCandidato);

        Assertions.assertEquals(novoPerfilCandidato.getNome(), "Joao Da Silva");
        Assertions.assertEquals(novoPerfilCandidato.getDescricao(), "O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar");
        Assertions.assertEquals(novoPerfilCandidato.getDuracao(), "01:00");

        Mockito.verify(capitalizador).executar("joao da silva");
        Mockito.verify(conversorDuracao).executar("60");
        Mockito.verify(truncadorDescricao).executar("O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar");
    }


}