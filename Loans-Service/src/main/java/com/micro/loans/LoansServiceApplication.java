package com.micro.loans;

import com.micro.loans.dto.LoansContactInfoDto;
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
				title = "API Documentation for Loan Microservice",
				contact = @Contact(
						name="Rohit Gunjal",
						email ="rohitgunjal547@gmail.com"
				)
		)
)
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@SpringBootApplication
public class LoansServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansServiceApplication.class, args);
	}

}
