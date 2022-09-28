package com.example.felix_backend.service;

import com.example.felix_backend.mapper.IngredientMapper;
import com.example.felix_backend.mapper.OrdersMapper;
import com.example.felix_backend.mapper.RecipeMapper;
import com.example.felix_backend.pojo.Ingredient;
import com.example.felix_backend.pojo.IngredientInRecipe;
import com.example.felix_backend.pojo.Recipe;
import com.example.felix_backend.response.RecipeToCook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CookService {
    @Resource
    private IngredientMapper ingredientMapper;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private RecipeMapper recipeMapper;
    public List<RecipeToCook> getAvailableRecipes(boolean vegan) {
        List<Recipe> allRecipes = vegan ? recipeMapper.findAllVegan() : recipeMapper.findAll();
        List<IngredientInRecipe> remainingItems = ordersMapper.findTotalRemaining();
        List<Ingredient> allItems = ingredientMapper.findAll();
        List<RecipeToCook> results = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            boolean isAvailable = true;
            int ingredientCost = 0;
            for (String s : recipe.getIngredients().split(", ")) {
                if (!isAvailable) {
                    break;
                }
                String[] split = s.split(":");
                Integer ingredientId = Integer.parseInt(split[0]);
                Integer ingredientAmount = Integer.parseInt(split[1]);
                for (IngredientInRecipe item : remainingItems) {
                    if (item.getId().equals(ingredientId)) {
                        if (item.getAmount() < ingredientAmount) {
                            isAvailable = false;
                            break;
                        }
                    }
                }
                for (Ingredient item : allItems) {
                    if (item.getId().equals(ingredientId)) {
                        ingredientCost += item.getPrice() * ingredientAmount;
                    }
                }
            }
            if (!isAvailable) {
                continue;
            }
            RecipeToCook recipeToCook = new RecipeToCook();
            recipeToCook.setId(recipe.getId());
            recipeToCook.setName(recipe.getName());
            recipeToCook.setVegan(recipe.isVegan());
            recipeToCook.setDescription(recipe.getDescription());
            recipeToCook.setEnergyCost(recipe.getEnergyCost());
            recipeToCook.setNutritionScore(recipe.getNutritionScore());
            recipeToCook.setIngredientCost(ingredientCost);
            results.add(recipeToCook);
        }
        return results;

    }

}
