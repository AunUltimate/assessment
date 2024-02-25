package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.request.LotteryRequest;
import com.kbtg.bootcamp.posttest.response.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LotteryService {
    @Autowired
    private DataSource dataSource;

    public void someMethod() {
        try (Connection connection = dataSource.getConnection()) {
            // Use the connection to interact with the database
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    private final LotteryRepository lotteryRepository;
    private final UserTicketRepository userTicketRepository;


    public LotteryService(LotteryRepository lotteryRepository, UserTicketRepository userTicketRepository) {
        this.lotteryRepository = lotteryRepository;
        this.userTicketRepository = userTicketRepository;
    }

    public LotteryResponse createLottery(LotteryRequest lotteryRequest) {
        LotteryEntity lottery = new LotteryEntity();
        lottery.setTicket(lotteryRequest.getTicket());
        lottery.setPrice(lotteryRequest.getPrice());
        lottery.setAmount(lotteryRequest.getAmount());
        lotteryRepository.save(lottery);
        return new LotteryResponse(lottery.getTicket());
    }
    public PostUserResponse createUserTicket(String userId, String ticketId) {

        UserTicketEntity userTicket = new UserTicketEntity();
        userTicket.setUserId(Integer.valueOf(userId));
        Optional<LotteryEntity> lottery = lotteryRepository.findById(Long.valueOf(ticketId));
        if(lottery.isEmpty()) {
            return new PostUserResponse("Ticket not found");
        }
        userTicket.setTicketId(lottery.get());
        userTicketRepository.save(userTicket);
        return new PostUserResponse(String.valueOf(userTicket.getId()));
    }

    public List<LotteryEntity> getLotteries() { return lotteryRepository.findAll(); }

    public LotterysResponse getTicketLotteries() {
        List<String> ticketLotteries = new ArrayList<>();
        ticketLotteries = lotteryRepository.findAll().stream().map(LotteryEntity::getTicket).toList();
        String[] tickets = ticketLotteries.toArray(new String[0]);
        return new LotterysResponse(tickets);
    }

    public DeleteTicketResponse deleteUserTicket(String userId, String ticketId) {
        Optional<LotteryEntity> lottery = lotteryRepository.findById(Long.valueOf(ticketId));
        if(lottery.isEmpty()) {
            return new DeleteTicketResponse("Ticket not found");
        }
        LotteryEntity lotteryEntity = lottery.get();
        userTicketRepository.deleteByUserIdAndTicketId(Integer.valueOf(userId), lotteryEntity);
        return new DeleteTicketResponse(lotteryEntity.getTicket());
    }

    public UserTicketResponse findByUserId(String userId) {
        List<UserTicketEntity>  userTicketEntities = userTicketRepository.findByUserId(Integer.valueOf(userId));
        int count = 0;
        int cost = 0;
        for(UserTicketEntity user : userTicketEntities) {
            count += user.getTicketId().getAmount();
            cost += user.getTicketId().getPrice();
        }
        String[] tickets = userTicketEntities
                .stream().map(UserTicketEntity::getTicketId)
                .map(LotteryEntity::getTicket).toArray(String[]::new);
        return new UserTicketResponse(tickets, String.valueOf(count), String.valueOf(cost));
    }
}

