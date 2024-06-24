package com.example.foodtrackerapplication;


import java.io.Serializable;

public class DailyMeals implements Serializable {

    private String id = "-1";
    private String day = "";
    private String meal = "";
    private String food = "";
    private String drink = "";
    private String snacks = "";


    public DailyMeals(String id, String day, String meal, String food, String drink, String snacks) {
        this.id = id;
        this.day = day;
        this.meal = meal;
        this.food = food;
        this.drink = drink;
        this.snacks = snacks;
    }

    public DailyMeals() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getSnacks() {
        return snacks;
    }

    public void setSnacks(String snacks) {
        this.snacks = snacks;
    }

    @Override
    public String toString() {
        return "DailyMeals{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", meal='" + meal + '\'' +
                ", food='" + food + '\'' +
                ", drink='" + drink + '\'' +
                ", snacks='" + snacks + '\'' +
                '}';
    }
}
