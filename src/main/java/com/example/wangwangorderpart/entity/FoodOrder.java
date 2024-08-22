package com.example.wangwangorderpart.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Data
@Slf4j
@Component
public class FoodOrder {
    int id;
    @Transient
    private int foodId;
    @ManyToOne
    @JoinColumn(name = "food_id")

    private Food food;
    private Time order_time;
    private int state;

}
