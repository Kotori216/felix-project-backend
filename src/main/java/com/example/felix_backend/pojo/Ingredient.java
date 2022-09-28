package com.example.felix_backend.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName ingredient
 */
@Data
public class Ingredient implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer price;

    private static final long serialVersionUID = 1L;
}