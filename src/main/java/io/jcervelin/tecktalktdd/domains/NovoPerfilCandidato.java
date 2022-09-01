package io.jcervelin.tecktalktdd.domains;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class NovoPerfilCandidato {
    private String nome;
    private String duracao;
    private String descricao;
    private String dataHoraInicio;
    private String dataHoraFim;
}
