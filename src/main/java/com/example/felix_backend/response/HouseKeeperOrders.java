package com.example.felix_backend.response;

import lombok.Data;

import java.util.Date;

@Data
public class HouseKeeperOrders {
    private Integer id;

    private Integer ingredientId;

    private String ingredientName;

    private Date bestBefore;

    private Date createTime;

    private Integer amount;

    private Integer usedAmount;

    private Integer wastedAmount;

    public Integer getRemainingAmount() {
        return amount - usedAmount - wastedAmount;
    }
}
