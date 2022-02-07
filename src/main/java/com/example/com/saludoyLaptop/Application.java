package com.example.com.saludoyLaptop;

import com.example.com.saludoyLaptop.entities.Laptop;
import com.example.com.saludoyLaptop.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context =	SpringApplication.run(Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
		Laptop laptop1 = new Laptop(null,"Hp","g32",4322.34, LocalDate.of(2020,11,2),true);

		System.out.println("Num libros en base de datos: " +	laptopRepository.findAll().size());

		laptopRepository.save(laptop1);
		System.out.println("Num libros en base de datos: " +	laptopRepository.findAll().size());
	}

}
