package io.jcervelin.tecktalktdd.domains;

import lombok.Data;

@Data
public class PerfilCandidato {
    private String nome;
    private String duracaoEmMinutos;
    private String descricao;
    private String dataInicio;
    private String horaInicio;
    private String dataFim;
    private String horaFim;
}

//{
//        "nome": "joao da silva",
//        "duracaoEmMinutos": 60,
//        "descricao": "O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar. No restante foi tudo bem",
//        "dataInicio": "2022-07-20",
//        "horaInicio": "13:30",
//        "dataFim": "2022-07-20",
//        "horaFim": "14:30"
//        }
