package com.banthatlung.Dao.model;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private int id;
    private String name;
    private int price;
    private String description;
    private int status;
    private int quantity;
    private String date;
    private String image;
    private Category category;
    private Brand brand;
    private Material material;

    public Product(int id, String name, int price, String description, int status, int quantity, String create, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
        this.quantity = quantity;
        this.image = image;

    }

    public Product(int id, String name, int price, String description, int status, int quantity, String date, String image, Category category, Brand brand, Material material) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
        this.quantity = quantity;
        this.date = date;
        this.image = image;
        this.category = category;
        this.brand = brand;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public static void main(String[] args) {
        Product p = new Product(1,"dsa",21,"sac",3,4,"today","dsa");
        System.out.println(p.getBrand().getName());
    }
}