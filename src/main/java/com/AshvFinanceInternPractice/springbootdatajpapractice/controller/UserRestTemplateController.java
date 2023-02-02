package com.AshvFinanceInternPractice.springbootdatajpapractice.controller;

import com.AshvFinanceInternPractice.springbootdatajpapractice.entity.User;
import com.AshvFinanceInternPractice.springbootdatajpapractice.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRestTemplateController {

    @Autowired
    private UserService userService;

    @Autowired
    RestTemplate restTemplate;
    ObjectMapper objectMapper = new ObjectMapper();
    String apiUrl = "http://localhost:8081/departments";
    String UserApiUrl = "https://gorest.co.in/public/v2/users";

    @GetMapping("/restApi/users")
    public List<Object> getAllRestApiUsers() throws JsonProcessingException {

        String usersList = restTemplate.getForObject(UserApiUrl, String.class);
        List<Object> users = objectMapper.readValue(usersList, new TypeReference<List<Object>>() {
        });

        return users;
    }


    @PostMapping("/restApi/users")
    public Object addRestApiUser(@RequestBody Object userData) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String accessToken="520bc50b709dc70cce5642219d1fb199a76b8d1d0bb26c4c29df99c399fcb50b";
        headers.set("Authorization", "Bearer "+accessToken);
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(UserApiUrl, HttpMethod.GET, entity, Object.class).getBody();

//        HttpEntity<Object> entity = new HttpEntity<Object>(userData,headers);
//        String result = restTemplate.postForObject(UserApiUrl, entity, String.class);
//        Object users = objectMapper.readValue(result,Object.class);
//        return users;
    }


    @GetMapping("/users")
    public List<User> getAllUsers() throws IOException {
        return  userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserId(@PathVariable("id") Long id){
        return userService.getUserId(id);
    }

    @GetMapping("/users/name/{name}")
    public User getUserId(@PathVariable("name") String name){
        return userService.getUserByName(name);
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);

    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id")  Long id, @RequestBody User user) {
        return userService.updateUser(user,id);

    }
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "User deleted Successfully";

    }








    @GetMapping("rest/departments")
    public List getDepartments(){

        //ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        ResponseEntity<List> response= restTemplate.getForEntity(apiUrl,List.class);
        List dept =response.getBody();
        return dept;
    }

    @PostMapping("rest/departments")
    public void addDepartment(@RequestBody Object department){
        String productCreateResponse = restTemplate
                .postForObject(apiUrl, department, String.class);
        System.out.print(productCreateResponse);

    }



    @GetMapping("rest/departments/{id}")
    public Object getDepartmentsById(@PathVariable("id") int id){
        return restTemplate.getForObject(apiUrl+"/"+id,Object.class);
    }

    @PutMapping("/rest/departments/{id}")
    public ResponseEntity updateEmployeeV1(@PathVariable final Integer id, @RequestBody Object department) {
        restTemplate.put(apiUrl+"/"+id, department);
        return new ResponseEntity("Employee Updated with id " + id, HttpStatus.OK);
    }


}
