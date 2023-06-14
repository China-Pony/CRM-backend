package com.example.crm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigration {

	@Bean
	SecurityFilterChain SecurityFiltterChain(HttpSecurity httpSecurity) throws Exception {
		// TODO Auto-generated method stub
		return httpSecurity.csrf(csrf -> {
			csrf.disable();
		}).authorizeHttpRequests(authrize -> {
			authrize.anyRequest().permitAll();
		}).build();
	}
}
