package ru.netology.cloudapiback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudApiBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApiBackApplication.class, args);
	}


	// todo
	// 1. Настроить обмен файлами без секюрити, протестировать работу всех методов
	// 2. Написать класс юзер, добавить нескольких для примера. добавить секюрити, проверить.
	// 3. Подвязать бэк к фронту. Проверить.
	// 4. добавить логирование. Проверить работу логгера


}
