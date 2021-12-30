package ru.etology.cloudapiback.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @DeleteMapping("/file")
    void deleteFile(){
        service.deleteFile;
    }


}
