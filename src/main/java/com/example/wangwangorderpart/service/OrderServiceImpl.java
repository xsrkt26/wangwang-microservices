package com.example.wangwangorderpart.service;

import com.example.wangwang.dao.OrderMapper;
import com.example.wangwang.entity.Order;
import com.example.wangwang.entity.order.FoodOrder;
import com.example.wangwang.entity.order.HotelOrder;
import com.example.wangwang.entity.order.TripOrder;
import com.example.wangwang.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public int createOrder(String order_type, int user_id) {
        try{
            String uuid = UUID.randomUUID().toString();
            orderMapper.createOrder(uuid, order_type, user_id,1);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int createFoodOrder(FoodOrder foodOrder) {
        orderMapper.createFoodOrder(foodOrder.getFood_id(), foodOrder.getState());
        return 1;
    }

    @Override
    public int createHotelOrder(HotelOrder hotelOrder) {
        orderMapper.createHotelOrder(hotelOrder.getRoom_id(),hotelOrder.getCheck_in_date(),hotelOrder.getCheck_out_date());
        return 0;
    }

    @Override
    public int createTripOrder(TripOrder tripOrder) {
        orderMapper.createTripOrder( tripOrder.getFrom_place_id(), tripOrder.getTo_place_id(), tripOrder.getTrip_id(), tripOrder.getRow(), tripOrder.getSeat());
        return 1;
    }
}
