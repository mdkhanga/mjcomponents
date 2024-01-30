package com.heavyduty.services;

import com.heavyduty.services.entities.UsersEntity;
import com.heavyduty.services.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ServicesApplication {



	public static void main(String[] args) {
		try {
			SpringApplication.run(ServicesApplication.class, args);

		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Configuration
	public class WebConfig implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
		}
	}



}
