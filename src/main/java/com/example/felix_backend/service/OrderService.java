package com.example.felix_backend.service;

import com.example.felix_backend.common.ApiResult;
import com.example.felix_backend.common.FelixException;
import com.example.felix_backend.mapper.IngredientMapper;
import com.example.felix_backend.mapper.OrdersMapper;
import com.example.felix_backend.pojo.Ingredient;
import com.example.felix_backend.pojo.Orders;
import com.example.felix_backend.response.HouseKeeperOrders;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private IngredientMapper ingredientMapper;

    public void createOrder(Orders orderRequest) {
        Orders order = new Orders();
        order.setIngredientId(orderRequest.getIngredientId());
        order.setAmount(orderRequest.getAmount());
        order.setBestBefore(orderRequest.getBestBefore());
        ordersMapper.insert(order);
    }

    public int waste(long id, Integer amount) {
        Orders order = ordersMapper.findById(id);
        if(order == null) {
            throw new FelixException("can't find order");
        }
        Integer remainingAmount = order.getRemainingAmount();
        Integer wastedAmount = order.getWastedAmount();
        if (remainingAmount <= 0) {
            throw new FelixException("order not available");
        }
        if (amount > remainingAmount) {
            amount = remainingAmount;
        }
        ordersMapper.waste(id, amount + wastedAmount);
        return amount;
    }

    public int deliver(long id, Integer amount) {
        Orders order = ordersMapper.findById(id);
        if(order == null) {
            throw new FelixException("can't find order");
        }
        Integer remainingAmount = order.getRemainingAmount();
        Integer usedAmount = order.getUsedAmount();
        if (remainingAmount <= 0) {
            throw new FelixException("order not available");
        }
        if (amount > remainingAmount) {
            amount = remainingAmount;
        }
        ordersMapper.use(id, amount + usedAmount);
        return amount;
    }


    public List<HouseKeeperOrders> listAll() {
        List<HouseKeeperOrders> orderList = ordersMapper.listAvailableOrders();
        return orderList;
    }


    public List<Ingredient> listItems() {
        return ingredientMapper.findAll();
    }
}
