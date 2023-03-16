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


//{
//        "nome": "Joao Da Silva",
//        "duracao": "1:00",
//        "descricao": "O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escola..",
//        "dataHoraInicio": "2022-07-20T13:30",
//        "dataHoraFim": "2022-07-20T14:30",
//        "horaFim": ""
//        }