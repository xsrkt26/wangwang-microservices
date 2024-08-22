package com.example.wangwangorderpart.controller;

import com.alibaba.fastjson.JSON;
import com.example.wangwang.config.annotation.TokenToUser;
import com.example.wangwang.entity.User;
import com.example.wangwang.entity.common.R;
import com.example.wangwang.entity.myenum.OrderType;
import com.example.wangwang.entity.order.FoodOrder;
import com.example.wangwang.entity.order.HotelOrder;
import com.example.wangwang.entity.order.TripOrder;
import com.example.wangwang.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/order")
@CrossOrigin
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;
    @PostMapping("/create")
    public R createOrder(@TokenToUser User user, @RequestBody HashMap<String,Object> orderMap) {
        if(user == null) {
            return R.error("invalid user token");
        }
        String type = (String) orderMap.get("order_type");
        OrderType order_type= OrderType.valueOf(type);
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            switch (order_type) {
                case trip_order:
                    String tripOrderJson = JSON.toJSONString(orderMap.get("trip_order"));
                    TripOrder tripOrder = objectMapper.readValue(tripOrderJson, TripOrder.class);
                    orderService.createTripOrder(tripOrder);
                case food_order:
                    String foodOrderJson = JSON.toJSONString(orderMap.get("food_order"));
                    FoodOrder foodOrder = objectMapper.readValue(foodOrderJson, FoodOrder.class);
                    orderService.createFoodOrder(foodOrder);
                case hotel_order:
                    String hotelOrderJson = JSON.toJSONString(orderMap.get("hotel_order"));
                    HotelOrder hotelOrder = objectMapper.readValue(hotelOrderJson, HotelOrder.class);
                    orderService.createHotelOrder(hotelOrder);
                default:
                    break;
            }
            orderService.createOrder(type, user.getUser_id());
            return R.ok();
        }catch (Exception e){
            return R.error(e.toString());
        }
    }
}