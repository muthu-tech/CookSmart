package com.smartcook.smartcook.Models;

import java.io.Serializable;

/**
 * Created by Kennedy Agusi on 3/24/2018.
 */

public class Items implements Serializable {
    String datePurchased;
    String foodItems;
    String recipeName;
    String receipeSuggestion;
    String directions;

    public Items(String datePurchased, String foodItems) {
        this.datePurchased = datePurchased;
        this.foodItems = foodItems;
    }

    public String getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(String datePurchased) {
        this.datePurchased = datePurchased;
    }

    public String getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(String foodItems) {
        this.foodItems = foodItems;
    }

    public String getReceipeSuggestion() {
        return receipeSuggestion;
    }

    public void setReceipeSuggestion(String receipeSuggestion) {
        this.receipeSuggestion = receipeSuggestion;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
