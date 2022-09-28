package com.example.felix_backend.mapper;


import com.example.felix_backend.pojo.Recipe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecipeMapper {

    @Select("SELECT * FROM recipe")
    List<Recipe> findAll();

    @Select("SELECT * FROM recipe WHERE vegan = 1")
    List<Recipe> findAllVegan();

}




