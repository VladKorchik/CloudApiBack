package ru.etology.cloudapiback.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping ("/login")
    void login(@RequestBody String email, @RequestBody String password){
        service.login;
    }

    @PostMapping ("/logout")
    void login(){
        service.logout;
    }

    @PostMapping ("/file")
    void uploadFile(){
        service.upload;
    }

}
