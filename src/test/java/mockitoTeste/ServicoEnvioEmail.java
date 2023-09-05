package mockitoTeste;

import br.rr.eduardo.exemplos.Email;
import br.rr.eduardo.exemplos.Formato;
import br.rr.eduardo.exemplos.PlataformaDeEnvio;

public class ServicoEnvioEmail {

    private PlataformaDeEnvio plataforma;

    void enviaEmail(String enderecoEmail, String mensagem, boolean formatoHtml) {

        Email email = null;

        if(formatoHtml) {
            email = new Email(enderecoEmail, mensagem, Formato.HTML);
        }else{
            email = new Email(enderecoEmail, mensagem, Formato.TEXTO);
        }

        plataforma.enviaEmail(email);
    }
}
