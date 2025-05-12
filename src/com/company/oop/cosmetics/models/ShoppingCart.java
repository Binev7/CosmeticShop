package com.company.oop.cosmetics.models;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if(!products.contains(product)) {
            throw new IllegalArgumentException("Shopping cart does not contain product with name ." + product.getName());
        }
        products.remove(product);
    }
    
    public boolean containsProduct(Product product) {
        return products.contains(product);
    }
    
    public double totalPrice() {
        double total = 0.00;
        for (Product product : products) {
            total +=product.getPrice();
        }
        return total;
    }
    
}
