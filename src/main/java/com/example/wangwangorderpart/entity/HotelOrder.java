package com.example.wangwangorderpart.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Slf4j
@Component
public class HotelOrder {
    @Id
    private int hotel_order_id;
    @Transient
    private int room_id;
    private Timestamp check_in_date;
    private Timestamp check_out_date;

}
