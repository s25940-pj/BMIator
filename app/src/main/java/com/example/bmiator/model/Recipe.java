package com.example.bmiator.model;

public class Recipe {
    public String title;
    public String description;
    public int calories;
    public String dietType;

    public Recipe(String title, String description, int calories, String dietType) {
        this.title = title;
        this.description = description;
        this.calories = calories;
        this.dietType = dietType;
    }
}
