package br.com.feltex.enviaremail;

import br.com.feltex.enviaremail.service.EnviaEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;

@SpringBootApplication
@Slf4j
public class ServicoEmail implements CommandLineRunner {

    private final EnviaEmailService enviaEmailService;

    public ServicoEmail(EnviaEmailService enviaEmailService) {
        this.enviaEmailService = enviaEmailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServicoEmail.class, args);
    }

    @Override
    public void run(String... args) throws MessagingException {
        enviaEmailService.enviar("usuario2.feltex@gmail.com", "FELTEX - Serviço de Email",
                "Conteúdo do email aqui!");

        enviaEmailService.enviarEmailComAnexo("usuario2.feltex@gmail.com", "FELTEX - Serviço de Email. Anexo",
                "Email com Anexo", "arquivos/basket.jpeg");
    }
}
