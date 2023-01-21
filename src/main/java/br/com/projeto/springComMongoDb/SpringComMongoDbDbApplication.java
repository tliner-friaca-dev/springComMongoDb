package br.com.projeto.springComMongoDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringComMongoDbDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringComMongoDbDbApplication.class, args);

		System.out.println("\n----------------------");
		System.out.println("ENTROU NA APLICAÇÃO!!!");
		System.out.println("----------------------\n");

	}

}
