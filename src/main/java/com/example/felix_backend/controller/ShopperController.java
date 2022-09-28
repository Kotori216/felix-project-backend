package com.example.felix_backend.controller;

import com.example.felix_backend.common.ApiResult;
import com.example.felix_backend.pojo.Ingredient;
import com.example.felix_backend.pojo.Orders;
import com.example.felix_backend.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/shopper")
public class ShopperController {
    @Resource
    private OrderService orderService;

    @PostMapping("/shop")
    public ApiResult handleShopping(@RequestBody Orders orderRequest) {
        orderService.createOrder(orderRequest);
        return ApiResult.success();
    }

    @GetMapping("/items")
    public ApiResult<List<Ingredient>> getItemList() {
        return ApiResult.success(orderService.listItems());
    }

}
