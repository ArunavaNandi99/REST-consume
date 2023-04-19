package com.consume.controller;

import com.consume.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Arrays;


@RestController
public class RestTemplateController {

    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/template/users")
    public String getProduct(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
         return restTemplate.exchange("http://localhost:8085", HttpMethod.GET,entity,String.class).getBody();
    }
    @PostMapping("/template/user")
    public String createUserByTemplate(@RequestBody User user){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<User>(user,headers);
        return restTemplate.exchange("http://localhost:8085/create", HttpMethod.POST,entity,String.class).getBody();
    }

    @PutMapping("/template/user/{id}")
    public String updateUserByTemplate (@PathVariable String id , @RequestBody User user){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<User>(user,headers);
        return restTemplate.exchange("http://localhost:8085/"+id,HttpMethod.PUT,entity,String.class).getBody();
    }

    @DeleteMapping("/template/user/{id}")
    public  String deleteUserByTemplate(@PathVariable String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8085/"+id,HttpMethod.DELETE,entity,String.class).getBody();
    }
}
