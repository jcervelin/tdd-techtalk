package io.jcervelin.tecktalktdd.existingclass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClasseExistenteTest {

    @InjectMocks
    private ClasseExistente target;

//    @Spy
//    private Dependencia mockDependencia;

    @Test
    public void deveRetornarNomeInteiro() {
        final String retorno = target.retornaNomeInteiro("Sr.", "Joao", "Silva");
        final String esperado = "Sr. joao SILVA";
        Assertions.assertEquals(esperado, retorno);
    }

    @Test
    public void deveRetornarExcecaoSeParametroNulo() {
        final RuntimeException retorno = Assertions.assertThrows(RuntimeException.class, () ->
                target.retornaNomeInteiro("Sr.", null, "Silva"));
        Assertions.assertEquals("Parametros obrigatorios", retorno.getMessage());
    }

//    @Test
//    public void deveRetornarNomeInteiroComSegundoNome() {
//        Mockito.doReturn("Pereira").when(mockDependencia).retornaSegundoNome("Francisco");
//
//        final String retorno = target.retornaNomeInteiro("Sr.", "Joao", "Francisco","Silva");
//        final String esperado = "Sr. joao Pereira SILVA";
//        Assertions.assertEquals(esperado, retorno);
//    }

}