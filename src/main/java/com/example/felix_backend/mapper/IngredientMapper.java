package com.example.felix_backend.mapper;


import com.example.felix_backend.pojo.Ingredient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IngredientMapper {
    @Select("SELECT * FROM ingredient WHERE id = #{id}")
    Ingredient findById(long id);

    @Select("SELECT * FROM ingredient")
    List<Ingredient> findAll();

}




