package com.example.felix_backend.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @TableName orders
 */
@Data
public class Orders implements Serializable {

    private Integer id;

    private Integer ingredientId;

    private Date bestBefore;

    private Date createTime;

    private Integer amount;

    private Integer usedAmount;

    private Integer wastedAmount;

    public Integer getRemainingAmount() {
        return amount - usedAmount - wastedAmount;
    }


    private static final long serialVersionUID = 1L;
}