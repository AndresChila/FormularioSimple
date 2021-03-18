package com.valid.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.valid")
@EntityScan(basePackages= {"com.valid.entity"})
@EnableJpaRepositories("com.valid.repository")
@EnableTransactionManagement
public class ProyectoFormulario1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFormulario1Application.class, args);
	}
	
}
