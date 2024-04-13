package com.micro;

import com.micro.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info=@Info(
				title = "API Documentation for Card Microservice",
				contact = @Contact(
						name="Rohit Gunjal",
						email ="rohitgunjal547@gmail.com"
				)
		)
)
@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
@SpringBootApplication
public class CardsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsServiceApplication.class, args);
	}

}
