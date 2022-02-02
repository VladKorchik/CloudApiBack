package ru.netology.cloudapiback.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class PostController {
    //todo тут можно подумать, не зашить ли потом путь в файл с настройками
    final static String FILES_SAVES_PATH = "./src/main/usersFiles/";

    //todo попробовать аннотацию Constructor (если такая есть вообще)
    @PostConstruct
    private static void init() {
        StringBuilder stringBuilder = new StringBuilder();
        File directory = new File(FILES_SAVES_PATH);
        if (directory.mkdir()) {
            //todo Надо потом сохранять это в логи и выводить на экран
            stringBuilder.append("Каталог " + directory.getName() + " создан\n");
        }
    }

    //todo добавить обработку для случаев, когда файл с таким именем уже существует
    @PostMapping("/file")
    @ResponseBody
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile uploadFile) {
        if (uploadFile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }
        try {
            byte[] bytes = uploadFile.getBytes();
            Path path = Paths.get(FILES_SAVES_PATH + uploadFile.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Success upload " +
                uploadFile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/file")
    public ResponseEntity deleteFile(@RequestParam String fileName) {
        if (fileName.isEmpty()) {
            return new ResponseEntity("Error input data", HttpStatus.BAD_REQUEST);
        }
        Path path = Paths.get(FILES_SAVES_PATH + fileName);
        if (!Files.exists(path)) {
            return new ResponseEntity("Error input data ", new HttpHeaders(), HttpStatus.BAD_REQUEST);
        } else {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ResponseEntity("Success deleted " + fileName, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @GetMapping("/file")
    public MultipartFile test(@RequestParam String fileName){
        MultipartFile file = new MultipartFile()
//                (FILES_SAVES_PATH + fileName) {
//        };
        return file;
    }


}