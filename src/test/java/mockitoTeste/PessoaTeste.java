package mockitoTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.rr.eduardo.exemplos.Pessoa;

/**
 * Teste da classe {@link Pessoa} que apresenta exemplos de manipulação de retorno com maior nível de detalhes
 */
@ExtendWith(MockitoExtension.class)
public class PessoaTeste {

    @Mock
    private Pessoa pessoa;

    @Test
    void escolheRetorno() {
        when(pessoa.getNome()).thenReturn("Will");
        assertEquals("Will", pessoa.getNome());
    }

    @Test
    void outraFormaDeEscolherRetorno() {
        doReturn("Will").when(pessoa).getNome();
        assertEquals("Will", pessoa.getNome());
    }

    @Test
    void retornaQueEhMaiorDeIdade() {
        when(pessoa.ehMaiorDeIdade()).thenReturn(true);
        assertTrue(pessoa.ehMaiorDeIdade());
    }

    @Test
    void retornaQueEhMaiorDeIdadeDeUmaOutraForma() {
        doAnswer(invocation -> true).when(pessoa).ehMaiorDeIdade();
        assertTrue(pessoa.ehMaiorDeIdade());
   }
}