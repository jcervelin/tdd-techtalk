package io.jcervelin.tecktalktdd.existingclass;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Dependencia {

    public String retornaPrimeiroNome(String primeiroNome) {
       return  primeiroNome.toLowerCase();
    }

    public String retornaSobreNome(String sobreNome) {
        return  sobreNome.toUpperCase();
    }

    public String retornaSegundoNome(String segundoNome) {
        return segundoNome.toUpperCase();
    }
}
