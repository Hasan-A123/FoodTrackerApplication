package com.example.foodtrackerapplication;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert.*;

public class DailyMealsTest {

    DailyMeals meals;

    @Before
    public void setUp() {
        meals = new DailyMeals();
    }

    @Test
    public void testGetId() {
        meals.setId("1");
        assertEquals("id is not equal to 1", String.valueOf(1), meals.getId());

    }

    @Test
    public void testSetId() {
        meals.setId("1");
        assertEquals("set id not equal 1", String.valueOf(1), meals.getId());
    }


    @Test
    public void testGetDay() {
        meals.setDay("Monday");
        assertEquals("set day is the incorrect day", "Monday", meals.getDay());
    }

    @Test
    public void testSetDay() {
        meals.setDay("Monday");
        assertEquals("set day is the incorrect day", "Monday", meals.getDay());

    }

    @Test
    public void testGetMeal() {
        meals.setMeal("Breakfast");
        assertEquals("set meal is the incorrect meal", "Breakfast", meals.getMeal());
    }


    @Test
    public void testSetMeal() {
        meals.setMeal("Breakfast");
        assertEquals("set meal is the incorrect meal", "Breakfast", meals.getMeal());
    }



    @Test
    public void testGetFood() {
        meals.setFood("Toast");
        assertEquals("set food is the incorrect food", "Toast", meals.getFood());
    }


    @Test
    public void testSetFood() {
        meals.setFood("Toast");
        assertEquals("set food is the incorrect food", "Toast", meals.getFood());
    }



    @Test
    public void testGetDrink() {
        meals.setDrink("Tea");
        assertEquals("set drink is the incorrect drink", "Tea", meals.getDrink());
    }



    @Test
    public void testSetDrink() {
        meals.setDrink("Tea");
        assertEquals("set drink is the incorrect drink", "Tea", meals.getDrink());
    }



    @Test
    public void testGetSnacks() {
        meals.setSnacks("Cereal Bar");
        assertEquals("set snacks is the incorrect snack", "Cereal Bar", meals.getSnacks());
    }


    @Test
    public void testSetSnacks() {
        meals.setSnacks("Cereal Bar");
        assertEquals("set snacks is the incorrect snack", "Cereal Bar", meals.getSnacks());
    }
}