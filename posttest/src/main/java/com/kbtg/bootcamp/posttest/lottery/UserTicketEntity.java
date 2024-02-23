package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_ticket")
public class UserTicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId, ticketId;
}
