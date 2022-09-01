package io.jcervelin.tecktalktdd.mapper;

import io.jcervelin.tecktalktdd.domains.NovoPerfilCandidato;
import io.jcervelin.tecktalktdd.domains.PerfilCandidato;
import io.jcervelin.tecktalktdd.mapper.regras.RegraMapeamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapeamentoPlataforma {

private final List<RegraMapeamento> regras;

    public NovoPerfilCandidato mapear(PerfilCandidato candidato) {
        NovoPerfilCandidato novo = new NovoPerfilCandidato();
        regras.forEach(regra -> regra.executar(candidato, novo));
        return novo;
    }

}
