package com.mikeyd.springmvcproject;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts() {
       return products;
    }

    public Product getProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
