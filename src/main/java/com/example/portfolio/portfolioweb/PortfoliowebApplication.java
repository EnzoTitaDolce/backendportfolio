package com.example.portfolio.portfolioweb;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.example.portfolio.portfolioweb", "com.example.portfolio.portfolioweb.DTO",
"com.example.portfolio.portfolioweb.control","com.example.portfolio.portfolioweb.enums",
"com.example.portfolio.portfolioweb.repository","com.example.portfolio.portfolioweb.repository.security",
"com.example.portfolio.portfolioweb.security.JWT","com.example.portfolio.portfolioweb.service"})
public class PortfoliowebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfoliowebApplication.class, args);
	}

}
