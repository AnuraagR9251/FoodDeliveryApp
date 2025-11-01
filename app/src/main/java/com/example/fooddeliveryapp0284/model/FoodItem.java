package com.example.fooddeliveryapp0284.model;

public class FoodItem {
    private String name;
    private double price;
    private int imageResource; // Using drawable resource for simplicity

    public FoodItem(String name, double price, int imageResource) {
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
    }

    // --- Getters ---
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }
}
