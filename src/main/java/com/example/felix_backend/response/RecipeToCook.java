package com.example.felix_backend.response;

import lombok.Data;

@Data
public class RecipeToCook {

    private Integer id;

    private String name;

    private Integer energyCost;

    private Integer ingredientCost;

    public Integer getTotalCost() {
        return energyCost + ingredientCost;
    }

    private String description;

    private boolean vegan;

    private Integer nutritionScore;

    public Rate getRate() {
        if (nutritionScore >= 50 && this.getTotalCost() <= 10) {
            return Rate.GREEN;
        }
        if (nutritionScore < 50 && this.getTotalCost() > 10) {
            return Rate.RED;
        }
        return Rate.AMBER;
    }
}
