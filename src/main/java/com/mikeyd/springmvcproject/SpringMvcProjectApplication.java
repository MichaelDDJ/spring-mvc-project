package com.mikeyd.springmvcproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectApplication.class, args);

		ProductService service = new ProductService();

		service.addProduct(new Product("Asus VivoBook", "Laptop", "Brown Table", 2022));
		service.addProduct(new Product("Dell laptop", "Laptop", "Office", 2018));
		service.addProduct(new Product("MacBook", "Laptop", "Office", 2025));
		service.addProduct(new Product("Surface", "Desktop", "Living room", 2025));
		service.addProduct(new Product("Samsung Galaxy", "Phone", "Bedroom", 2024));
		service.addProduct(new Product("Lenovo", "Monitor", "Office", 2026));
		service.addProduct(new Product("Acer", "Monitor", "Brown Table", 2026));

		List<Product> products = service.getAllProducts();
		for(Product product : products) {
			System.out.println(product);
		}

		//line to divide results
		System.out.println("==================================================================");

		System.out.println(service.getProductByName("MacBook"));
	}
}
