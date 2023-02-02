package com.AshvFinanceInternPractice.springbootdatajpapractice.service;

import com.AshvFinanceInternPractice.springbootdatajpapractice.entity.User;
import com.AshvFinanceInternPractice.springbootdatajpapractice.repository.UserRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

   RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();

    public User saveDepartment(User user) {
        userRepository.save(user);
        return user;
    }
    public List<User> getAllUsers() throws JsonProcessingException {
        List<User> userList =userRepository.findAll();
        if (userList.isEmpty()) {
            String url = "https://gorest.co.in/public/v2/users";

            String output = restTemplate.getForObject(url, String.class);

            List<User> users = objectMapper.readValue(output, new TypeReference<List<User>>() {
            });
            userRepository.saveAll(users);
            return users;
            //return userList;
        }else{
            return userList;
        }

    }
    public Optional<User> getUserId(Long id) {

           return  userRepository.findById(id);
    }



    public String addUser(User user) {
        Optional<User> existUser = Optional.ofNullable(userRepository.findByNameIgnoreCase(user.getName()));
        if(existUser.isEmpty()){
            userRepository.save(user);
            return "User added Successfully";
        }else return "User already exists";

    }

    public User updateUser(User user, Long id) {

        User userDb = userRepository.findById(id).get();
        if(Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())){
            userDb.setName(user.getName());
        }
        if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())){
            userDb.setEmail(user.getEmail());
        }
        if(Objects.nonNull(user.getGender()) && !"".equalsIgnoreCase(user.getGender())){
            userDb.setGender(user.getGender());
        }

        if(Objects.nonNull(user.getStatus()) && !"".equalsIgnoreCase(user.getStatus())){
            userDb.setStatus(user.getStatus());
        }

        return userRepository.save(userDb);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


    public User getUserByName(String name) {
        return userRepository.findByNameIgnoreCase(name);
    }

}

