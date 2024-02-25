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

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private LotteryEntity ticketId;


}
