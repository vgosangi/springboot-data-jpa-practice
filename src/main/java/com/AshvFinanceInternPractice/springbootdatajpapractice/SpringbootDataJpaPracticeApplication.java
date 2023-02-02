package com.AshvFinanceInternPractice.springbootdatajpapractice;

import com.AshvFinanceInternPractice.springbootdatajpapractice.repository.UserRepository;
import com.AshvFinanceInternPractice.springbootdatajpapractice.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication

public class SpringbootDataJpaPracticeApplication {
	public static void  main(String[] args) throws IOException {
		SpringApplication.run(SpringbootDataJpaPracticeApplication.class, args);
		//UserService userService = new UserService();

		String UserApiUrl = "https://gorest.co.in/public/v2/users";

//		RestTemplate restTemplate = new RestTemplate();
//		List response= restTemplate.getForEntity(UserApiUrl,List.class).getBody();
//		assert response != null;System.out.println(response);

		UserRepository userRepository;



	}
}