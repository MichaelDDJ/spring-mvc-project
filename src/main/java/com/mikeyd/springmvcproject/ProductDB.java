package com.mikeyd.springmvcproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection conn = null;

    public ProductDB(){
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "132465p");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(Product p){
        String query = "insert into product (name, type, place, warranty) values (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getType());
            stmt.setString(3, p.getPlace());
            stmt.setInt(4, p.getWarranty());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll(){
        List<Product> products = new ArrayList<>();

        String query = "select name,type,place,warranty from product";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                String place = rs.getString("place");
                int warranty = rs.getInt("warranty");
                Product product = new Product(name, type, place, warranty);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}
