package com.company.oop.cosmetics.models;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class Category {
    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 15;

    private String name;
    private ArrayList<Product> products;


    public Category(String name) {
        setName(name);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Name should be between 2 and 15 symbols.");
        }
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if(!products.contains(product)) {
            throw new IllegalArgumentException("Product not found in category.");
        }
        products.remove(product);
    }
    
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("#Cattegory: ").append(name).append("\n");
        if(products.isEmpty()) {
            sb.append("#No product in this category");
        } else {
            for (Product product : products) {
                sb.append(" ").append(product.print()).append("\n");
                sb.append(" ===\n");
            }
        }

        return sb.toString();
    }
    
}