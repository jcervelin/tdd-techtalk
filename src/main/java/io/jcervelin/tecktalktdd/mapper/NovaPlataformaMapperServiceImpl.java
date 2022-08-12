package io.jcervelin.tecktalktdd.mapper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import io.jcervelin.tecktalktdd.mapper.regras.Capitalizador;
import io.jcervelin.tecktalktdd.mapper.regras.ConversorDuracao;
import io.jcervelin.tecktalktdd.mapper.regras.TruncadorDescricao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NovaPlataformaMapperServiceImpl implements NovaPlataformaMapperService {

    private final ObjectMapper objectMapper;
    private final Capitalizador capitalizador;
    private final ConversorDuracao conversorDuracao;
    private final TruncadorDescricao truncadorDescricao;

    @Override
    public String mapMetadata(String metadata) {
        try {
            final PerfilCandidato perfilCandidato = objectMapper.readValue(metadata, PerfilCandidato.class);

            NovoPerfilCandidato novoPerfilCandidato = new NovoPerfilCandidato();
            novoPerfilCandidato.setNome(capitalizador.capitalizar(perfilCandidato.getNome()));
            novoPerfilCandidato.setDuracao(conversorDuracao.converter(perfilCandidato.getDuracaoEmMinutos()));
            novoPerfilCandidato.setDescricao(truncadorDescricao.truncar(perfilCandidato.getDescricao()));

            return objectMapper.writeValueAsString(novoPerfilCandidato);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
