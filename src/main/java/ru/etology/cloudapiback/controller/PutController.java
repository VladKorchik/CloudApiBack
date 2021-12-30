package ru.etology.cloudapiback.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutController {

    @PutMapping("/file")
    void editFileName() {
        service.editFileName;
    }

}
