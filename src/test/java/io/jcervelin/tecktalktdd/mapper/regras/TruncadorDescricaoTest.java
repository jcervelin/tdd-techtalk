package io.jcervelin.tecktalktdd.mapper.regras;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TruncadorDescricaoTest {

    @InjectMocks
    private TruncadorDescricao alvo;

    @Test
    public void descricaoDeveRetornarComSucesso() {
        String request = "O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar";
        String esperado = "O candidato se mostrou apreensivo ao ser perguntado sobre seu histórico escolar";
        String retorno = alvo.truncar(request);

        assertEquals(esperado, retorno);
    }

    @Test
    public void descricaoDeveRetornarTruncado() {
        String request = "O candidato Sálvio se mostrou apreensivo ao ser perguntado sobre seu histórico escolar";
        String esperado = "O candidato Sálvio se mostrou apreensivo ao ser perguntado sobre seu histórico..";
        String retorno = alvo.truncar(request);

        assertEquals(esperado, retorno);
    }

}