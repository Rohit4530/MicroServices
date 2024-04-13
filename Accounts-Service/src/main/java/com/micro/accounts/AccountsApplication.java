package com.micro.accounts;

import com.micro.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info=@Info(
				title = "API Documentation for Account Microservice",
				contact = @Contact(
						name="Rohit Gunjal",
						email ="rohitgunjal547@gmail.com"
				)
		)
)
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@SpringBootApplication
@EnableFeignClients
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
