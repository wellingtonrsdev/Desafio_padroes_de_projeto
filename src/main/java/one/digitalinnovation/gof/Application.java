package one.digitalinnovation.gof;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API-Clientes",
				version = "1.0",
				description = "Documentando uma API de Cadastro de Clientes, implementada com padrões de projetos Singleton, Strategy, Facade.",
				contact = @Contact(name = "Wellington Rodrigues", email = "rodrigueswellington3@gmail.com")
		)
)

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
