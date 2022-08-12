package io.jcervelin.tecktalktdd.domains;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class NovoPerfilCandidato {
    private String nome;
    private LocalTime duracao;
    private String descricao;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
}
