package com.example.wangwangorderpart.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Data
@Slf4j
@Entity
@Component
public class Order {
    @Id
    private String order_id;
    @Enumerated(EnumType.STRING)
    private OrderType order_type;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private Time create_time;
    private int state;
    private FoodOrder foodOrder;
    private HotelOrder hotelOrder;
    private TripOrder tripOrder;

}
