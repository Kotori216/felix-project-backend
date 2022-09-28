package com.example.felix_backend.mapper;

import com.example.felix_backend.pojo.IngredientInRecipe;
import com.example.felix_backend.pojo.Orders;
import com.example.felix_backend.response.HouseKeeperOrders;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrdersMapper {

    @Insert("INSERT INTO orders (ingredient_id, best_before, amount) VALUES(#{ingredientId}, #{bestBefore}, #{amount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Orders order);

    @Select("SELECT * FROM orders WHERE id = #{id}")
    Orders findById(long id);

    @Update("UPDATE orders Set wasted_amount = #{amount} WHERE id = #{id}")
    void waste(long id, Integer amount);

    @Update("UPDATE orders Set used_amount = #{amount} WHERE id = #{id}")
    void use(long id, Integer amount);

    @Select("SELECT orders.id as id, name as ingredient_name, ingredient_id, best_before, create_time, amount, wasted_amount, used_amount FROM orders LEFT JOIN ingredient on orders.ingredient_id = ingredient.id WHERE wasted_amount + used_amount < amount")
    List<HouseKeeperOrders> listAvailableOrders();

    @Select("SELECT * FROM orders WHERE id = #{id}")
    List<Orders> findAll();

    @Select("select ingredient_id as id, sum(amount - used_amount - wasted_amount) as amount from orders where best_before >= cast((now()) as date) group by ingredient_id")
    List<IngredientInRecipe> findTotalRemaining();

}



