package com.mikeyd.springmvcproject;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class ProductService {

    List<Product> products = new ArrayList<>();
    ProductDB db = new ProductDB();
    public void addProduct(Product p){

        products.add(p);

        db.save(p);
    }

    public List<Product> getAllProducts() {

        return db.getAll();
    }

    public Product getProductByName(String name) {
        Stream<Product> data = products.stream();
        return data.filter(p -> p
                        .getName().equals(name))
                        .findFirst()
                        .orElse(null);

        /*for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;*/
    }


    public List<Product> getProductsWithText(String text) {

        List<Product> prods = new ArrayList<>();

        for (Product p : products) {
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();

            if (name.contains(text.toLowerCase()) || type.contains(text.toLowerCase()) || place.contains(text.toLowerCase())) {
                prods.add(p);
            }
        }
        return prods;
    }

    public List<Product> getProductsInWarranty(){
        List<Product> prods = new ArrayList<>();

        for (Product p : products) {
            if(p.getWarranty() >= Year.now().getValue()) {
                prods.add(p);
            }
        }
        return prods;
    }
}
