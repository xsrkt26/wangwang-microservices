package com.example.wangwangorderpart.dao;

import org.apache.ibatis.annotations.*;

import java.sql.Time;
import java.sql.Timestamp;


public interface OrderMapper {
    @Insert("insert into `order` (order_id, order_type, user_id, state) VALUES (#{order_id}, #{order_type}, #{user_id},#{state})")
    void createOrder(String order_id, String order_type, int user_id, int state);
    @Insert("""
    insert into trip_order (from_place_id, to_place_id, trip_id, `row`, seat)
    VALUES ( #{from_place_id}, #{to_place_id},#{trip_id}, #{row}, #{seat})
    """)
    void createTripOrder( int from_place_id, int to_place_id, int trip_id, int row, int seat);
    @Insert("""
    insert into food_order(food_id, order_time, state) VALUES
    (#{food_id}, now(), #{state})
    """)
    void createFoodOrder(int food_id,  int state);
    @Insert("""
    insert into hotel_order(room_id, check_in_date, check_out_date) values
    (#{room_id}, #{check_in_date}, #{check_out_date})
    """)
    @Select("select * from hotel_order where hotel_order_id = #{id}")
    void selectHotelOrderById(int id);
    @Select("select * from food_order where food_order_id = #{id}")
    void selectFoodOrderById(int id);
    @Select("select * from trip_order where trip_order_id = #{id}")
    void selectTripOrderById(int id);
    void createHotelOrder(int room_id, Timestamp check_in_date, Timestamp check_out_date);
    @Results({
            @Result(property = "foodOrder", column = "reference_id",
                    one = @One(select = daoUrl + "OrderMapper.selectFoodOrderById"))
    })
    @Select("select * from `order` where user_id = #{user_id}")
    void selectFoodOrdersByUser(int user_id);
    @Results({
            @Result(property = "hotelOrder", column = "reference_id",
                    one = @One(select = daoUrl + "OrderMapper.selectHotelOrderById"))
    })
    @Select("select * from `order` where user_id = #{user_id}")
    void selectHotelOrdersByUser(int user_id);
    @Results({
            @Result(property = "tripOrder", column = "reference_id",
                    one = @One(select = daoUrl + "OrderMapper.selectTripOrderById"))
    })
    @Select("select * from `order` where user_id = #{user_id}")
    void selectTripOrdersByUser(int user_id);
}
