package com.mikeyd.springmvcproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectApplication.class, args);

		ProductService service = new ProductService();

		service.addProduct(new Product("Asus VivoBook", "Laptop", "Brown Table", 2022));
		service.addProduct(new Product("Dell laptop", "Laptop", "Office", 2018));
		service.addProduct(new Product("MacBook", "Laptop", "Office", 2025));
		service.addProduct(new Product("Surface", "Desktop", "Livingroom", 2025));
		service.addProduct(new Product("Samsung Galaxy", "Phone", "Bedroom", 2024));
		service.addProduct(new Product("Lenovo", "Monitor", "Office", 2026));
		service.addProduct(new Product("Acer", "Monitor", "Brown Table", 2026));
	}
}
