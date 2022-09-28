package com.example.felix_backend.controller;

import com.example.felix_backend.common.ApiResult;
import com.example.felix_backend.pojo.Orders;
import com.example.felix_backend.response.HouseKeeperOrders;
import com.example.felix_backend.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/housekeeper")
public class HouseKeeperController {
    @Resource
    private OrderService orderService;

    @PutMapping("/waste")
    public ApiResult<Integer> waste(@RequestParam long id, @RequestParam int amount) {
        int wasted = orderService.waste(id, amount);
        return ApiResult.success(wasted);
    }

    @PutMapping("/deliver")
    public ApiResult<Integer> deliver(@RequestParam long id, @RequestParam int amount) {
        int wasted = orderService.deliver(id, amount);
        return ApiResult.success(wasted);
    }

    @GetMapping("/list")
    public ApiResult<List<HouseKeeperOrders>> listAvailableItems() {
        List<HouseKeeperOrders> orders = orderService.listAll();
        return ApiResult.success(orders);
    }
}