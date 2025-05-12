package com.company.oop.cosmetics.models;

import java.util.Objects;

public class Product {

    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_MIN_LENGTH = 2;
    private static final int BRAND_MAX_LENGTH = 10;

    // "Each product in the system has name, brand, price and gender."    /YES
    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        // finish the constructor and validate data      /YES
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0) {
            throw new IllegalArgumentException("Price should be non negative.");
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH ) {
            throw new IllegalArgumentException("Name should be between 2 and 10 symbols.");
        }
        this.name = name;
    }

    public String getBrand() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void setBrand(String brand) {
        if(brand == null || brand.length() < BRAND_MIN_LENGTH || brand.length() > BRAND_MAX_LENGTH ) {
            throw new IllegalArgumentException("Brand should be between 3 and 10 symbols.");
        }
        this.brand = brand;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender type can be [Men, Women or Unisex].");
        }
        this.gender = gender;
    }

    public String print() {
        // Format:
        //" #[Name] [Brand]
        // #Price: [Price]
        // #Gender: [Gender]
        // ==="
        return String.format("#%s %s\n #Price: $%.2f\n #Gender: %s",
                this.name, this.brand, this.price, this.gender.toString().toUpperCase());
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Product product = (Product) p;
        return Double.compare(this.getPrice(), product.getPrice()) == 0 &&
                Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getBrand(), product.getBrand()) &&
                this.getGender() == product.getGender();
    }
    
}
