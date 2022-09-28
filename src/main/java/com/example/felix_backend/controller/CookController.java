package com.example.felix_backend.controller;

import com.example.felix_backend.common.ApiResult;
import com.example.felix_backend.response.RecipeToCook;
import com.example.felix_backend.service.CookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/cook")
public class CookController {

    @Resource
    private CookService cookService;

    @GetMapping("/recipes")
    public ApiResult<List<RecipeToCook>> getRecipes(@RequestParam boolean vegan) {
        List<RecipeToCook> recipes = cookService.getAvailableRecipes(vegan);
        return ApiResult.success(recipes);
    }

}
