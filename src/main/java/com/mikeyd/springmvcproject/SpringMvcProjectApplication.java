package com.mikeyd.springmvcproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Year;
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
		service.addProduct(new Product("Asus", "Monitor", "Brown Table", 2026));

		List<Product> products = service.getAllProducts();
		for(Product product : products) {
			System.out.println(product);
		}

		//line to divide results
		System.out.println("==================================================================");
		System.out.println("Search by name");

		System.out.println(service.getProductByName("MacBook"));

		System.out.println("==================================================================");
		System.out.println("Search by any text");

		List<Product> prods = service.getProductsWithText("Monitor");
		for(Product product : prods) {
			System.out.println(product);
		}

		System.out.println("==================================================================");
		System.out.println("Search by warranty");

		List<Product> warrantyProducts = service.getProductsInWarranty();
        for (Product product : warrantyProducts) {
            System.out.println(product);
        }


	}
}
