package br.com.jonatashub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.jonatashub.config.GreetingConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(GreetingConfiguration.class)
public class StartUp {

	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}

}
