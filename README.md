Dias & Dias Parado Ltda., uma empresa do ramo de recrutamento,  está migrando sua plataforma de dados. Você, como parte do time de migração, precisa trabalhar na seguinte tarefa:

## Cenario:

Como um usuário, eu preciso ver meus dados da seguinte maneira:

Nome Completo (Capitalizar a primeira letra de cada palavra ex.: Joao Da Silva)
Duração da entrevista no formato hh:mm
Descrição (limitado a 80 caracteres com  '..' no final)
Inicio da entrevista em yyyy-MM-ddTHH:mm:ss				
Fim da entrevista em yyyy-MM-ddTHH:mm:ss

Atualmente os dados guardados estão no seguinte formato:

Nome
Duracao em minutos
Descricao
Data Inicial no formato yyyy-MM-dd
Hora Inicial no formato HH:mm:ss
Data Final no formato yyyy-MM-dd
Hora Final no formato HH:mm:ss


O analista de sistemas analisou as informações existentes e criou o seguinte Data-mapping: 		

| Banco de dados DDP |                Nova plataforma                |                                                                                                                                                                                                                             Exemplos |
|:-------------------|:---------------------------------------------:|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| Nome               |                     Nome                      |                                                                                                                                                        Capitalising the first letter of each word 'Joao da silva' -> 'Joao Da Silva' |
| Duracao em minutos |                    Duracao                    |                                                                                                                                                          Convert long value to hh:mm format - 90 -> 01:30, 120 -> 02:00, 15 -> 00:15 |
| Descricao          |                   Descricao                   | Truncate to 80 characters with '..' in the end 'this is a more than eighty character description that needs to be truncated to 80 characters.' -> 'this is a more than eighty character description that needs to be truncated to..' |
| Data Inicio        |        Data Inicio + "T" + Hora Inicio        |                                                                                                                                                                                                                     yyyy-MM-ddTHH:mm |
| Data Fim           |           Data Fim + "T" + Hora Fim           |                                                                                                                                                                                                                     yyyy-MM-ddTHH:mm |


Este novo conversor será usado como uma biblioteca. O código que vai usar este conversor já está pronto.


O que precisamos fazer é implementar a seguinte interface:

```
public interface NovaPlataformaMapperService {
    String mapMetadata(String npMetadata);
}
```

Este serviço de mapeamento deve rejeitar os seguintes requests:											
* Data final antes de data inicial
* Duração da entrevista sendo mais que a diferença do fim com o início da entrevista

## Notas

Exemplo de um request:
```
{
    "nome": "joao da silva",
    "duracaoEmMinutos": 60,
    "descricao": "O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar",
    "dataInicio": "2022-07-20",
    "horaInicio": "13:00",
    "dataFim": "2022-07-20",
    "horaFim": "13:30"
}
```

## Desafio adicional

Usar algum pattern para evitar muitas dependencias em NovaPlataformaMapperServiceImpl