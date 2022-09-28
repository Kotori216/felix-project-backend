package com.example.felix_backend.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName recipe
 */
@Data
public class Recipe implements Serializable {

    private Integer id;

    private String name;

    private String ingredients;

    private Integer energyCost;

    private String description;

    private boolean vegan;

    private Integer nutritionScore;

    private static final long serialVersionUID = 1L;
}