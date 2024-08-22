package com.example.wangwangorderpart.service;

import com.example.wangwang.entity.Order;
import com.example.wangwang.entity.order.FoodOrder;
import com.example.wangwang.entity.order.HotelOrder;
import com.example.wangwang.entity.order.TripOrder;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {
    int createOrder(String order_type, int user_id);
    int createFoodOrder(FoodOrder foodOrder);
    int createHotelOrder(HotelOrder hotelOrder);
    int createTripOrder(TripOrder tripOrder);
}
