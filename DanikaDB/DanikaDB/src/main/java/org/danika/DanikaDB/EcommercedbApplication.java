package org.danika.DanikaDB;

import org.danika.DanikaDB.jwt.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommercedbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercedbApplication.class, args);
	}//main
	
//	@Bean
//	public FilterRegistrationBean<JwtFilter> jwtFilter(){
//		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
//		registrationBean.setFilter(new JwtFilter());
//		registrationBean.addUrlPatterns("/api/usuarios/*");
//		registrationBean.addUrlPatterns("/api/productos/*");
//
//		return registrationBean;
//	}//jwtFilter

}//class


