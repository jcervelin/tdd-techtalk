package io.jcervelin.tecktalktdd.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import io.jcervelin.tecktalktdd.mapper.regras.Capitalizador;
import io.jcervelin.tecktalktdd.mapper.regras.ConversorDuracao;
import io.jcervelin.tecktalktdd.mapper.regras.Regra;
import io.jcervelin.tecktalktdd.mapper.regras.TruncadorDescricao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NovaPlataformaMapperServiceImpl implements NovaPlataformaMapperService {

    private final ObjectMapper objectMapper;
    private final List<Regra> regras;

    @Override
    public String mapMetadata(String metadata) {
        try {
            final PerfilCandidato perfilCandidato = objectMapper.readValue(metadata, PerfilCandidato.class);

            final NovoPerfilCandidato novoPerfilCandidato = new NovoPerfilCandidato();

            regras.forEach(regra -> regra.executar(perfilCandidato, novoPerfilCandidato));

            return objectMapper.writeValueAsString(novoPerfilCandidato);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
