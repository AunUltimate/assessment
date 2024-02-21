package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "lottery")
public class LotteryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ticket;

    private Integer price;

    private Integer amount;


}
