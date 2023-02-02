package com.AshvFinanceInternPractice.springbootdatajpapractice.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class Restapi {
    @Bean
    public RestTemplate restTemplate(){
     return new RestTemplate();


//        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl+"/1", String.class);
//        String productsJson = response.getBody();
//        ResponseEntity<List> response= restTemplate.getForEntity(apiUrl,List.class);
//        List<Object> dept =response.getBody();
//
//        HttpEntity<?> request = new HttpEntity<>(new Department("CSE","Hyderabad","CSE-009"));
//
//        System.out.println(dept);
    }
}