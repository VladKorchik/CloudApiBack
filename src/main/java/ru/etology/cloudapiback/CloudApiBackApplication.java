package ru.etology.cloudapiback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudApiBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApiBackApplication.class, args);
	}

	// todo
	// 1. Настроить обмен файлами без секюрити
	// 2. Написать класс юзер и добавить секюрити
	// 3. Подвязать бэк к фронту


}
