package com.ev.workshop.api.tractorworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.ev.workshop.api.tractorworkshop.security.JwtAuthenticationProvider;

@SpringBootApplication
@RestController
public class TractorworkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TractorworkshopApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder encoder(){ return new BCryptPasswordEncoder(); }

	@Bean
	public JwtAuthenticationProvider provider(){ return new JwtAuthenticationProvider(); }


}
