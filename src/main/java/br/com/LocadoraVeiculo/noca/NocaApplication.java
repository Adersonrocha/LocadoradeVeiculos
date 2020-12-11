package br.com.LocadoraVeiculo.noca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EntityScan(basePackages = "br.com.LocadoraVeiculo.noca.model")
@ComponentScan(basePackages = { "br.com.LocadoraVeiculo.*" })
@EnableJpaRepositories(basePackages = { "br.com.LocadoraVeiculo.noca.repository" })
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class NocaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NocaApplication.class, args);
	}

}
