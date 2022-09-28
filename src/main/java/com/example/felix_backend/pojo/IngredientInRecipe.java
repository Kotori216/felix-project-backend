package com.example.felix_backend.pojo;

import lombok.Data;

@Data
public class IngredientInRecipe {
    private Integer id;

    private Integer amount;

    private Integer pricePerItem;
}
