package com.example.wangwangorderpart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @Column(name = "hotel_id") // 对应数据库中的 "hotel_id" 列
    private Integer hotelId;

    @Column(name = "name") // 对应数据库中的 "name" 列
    private String name;

    @Column(name = "description") // 对应数据库中的 "description" 列
    private String description;

    @Column(name = "picture_path") // 对应数据库中的 "picture_path" 列
    private String picturePath;

    @Column(name = "score") // 对应数据库中的 "score" 列
    private BigDecimal score;
}
