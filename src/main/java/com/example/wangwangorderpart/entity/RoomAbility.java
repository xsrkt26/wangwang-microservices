package com.example.wangwangorderpart.entity;

import com.example.wangwangorderpart.common.constant.RoomType;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "roomability")
public class RoomAbility {

    @EmbeddedId
    private RoomAbilityId id;

    @Column(name = "remaining_rooms", nullable = false)
    private int remainingRooms;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Embeddable
    public static class RoomAbilityId implements Serializable {

        @Column(name = "hotel_id")
        private int hotelId;

        @Enumerated(EnumType.STRING)
        @Column(name = "room_type")
        private RoomType roomType;

        @Column(name = "date")
        private LocalDate date;
    }
}
