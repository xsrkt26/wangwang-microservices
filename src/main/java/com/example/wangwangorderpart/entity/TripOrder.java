package com.example.wangwangorderpart.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Data
@Slf4j
@Component
public class TripOrder {
    @Id
    private int trip_order_id;
    private Time order_time;
    private int state;
    private double payment;
    private int trip_id;
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;
    private int carriage;
    private int row;
    private int seat;
    private Time payTime;
    @Enumerated(EnumType.STRING)
    private PayWay pay_way;
    private int from_place_id;
    private int to_place_id;
    @ManyToOne
    @JoinColumn(name = "from_place_id")
    private Station from_place;
    @ManyToOne
    @JoinColumn(name="to_place_id")
    private Station to_place;
    private int passenger_id;
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;
}
