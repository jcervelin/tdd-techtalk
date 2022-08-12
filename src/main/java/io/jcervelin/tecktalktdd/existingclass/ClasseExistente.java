package io.jcervelin.tecktalktdd.existingclass;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ClasseExistente {

    private final Dependencia dependencia;

    public String retornaNomeInteiro(String tratamento, String primeiroNome, String sobreNome) {
        if (!StringUtils.hasLength(tratamento) || !StringUtils.hasLength(primeiroNome) || !StringUtils.hasLength(sobreNome)) {
            throw new RuntimeException("Parametros obrigatorios");
        }
        return tratamento + " " + dependencia.retornaPrimeiroNome(primeiroNome)
                + " " +  dependencia.retornaSobreNome(sobreNome);
    }

    public String retornaNomeInteiro(String tratamento, String primeiroNome, String segundoNome, String sobreNome) {
        return tratamento + " " + dependencia.retornaPrimeiroNome(primeiroNome)
                + " " + dependencia.retornaSegundoNome(segundoNome) + " " + dependencia.retornaSobreNome(sobreNome);
    }
}
