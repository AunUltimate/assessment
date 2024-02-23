package com.kbtg.bootcamp.posttest.lottery;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LotteryService {

    private final LotteryRepository lotteryRepository;
    private final UserTicketRepository userTicketRepository;

    public LotteryService(LotteryRepository lotteryRepository, UserTicketRepository userTicketRepository) {
        this.lotteryRepository = lotteryRepository;
        this.userTicketRepository = userTicketRepository;
    }

    public LotteryResponseDto createLottery(LotteryRequestDto lotteryRequestDto) {
        LotteryEntity lottery = new LotteryEntity();
        lottery.setTicket(lotteryRequestDto.getTicket());
        lottery.setPrice(lotteryRequestDto.getAmount());
        lottery.setAmount(lotteryRequestDto.getPrice());
        lotteryRepository.save(lottery);
        return new LotteryResponseDto(lottery.getTicket());
    }
    public UserTicketResponseDto createUserTicket(String userId, String ticketId) {

        UserTicketEntity userTicket = new UserTicketEntity();
        userTicket.setUserId(userId);
        userTicket.setTicketId(ticketId);
        userTicketRepository.save(userTicket);
        return new UserTicketResponseDto(userTicket.getUserId());
    }

    public List<LotteryEntity> getLotteries() { return lotteryRepository.findAll(); }

    public LotterysResponseDto getTicketLotteries() {
        List<String> ticketLotteries = new ArrayList<>();
//        for(LotteryEntity lottery : lotteryRepository.findAll()) {
//            ticketLotteries.add(lottery.getTicket());
//
//        }
        ticketLotteries = lotteryRepository.findAll().stream().map(LotteryEntity::getTicket).toList();
        String[] tickets = ticketLotteries.toArray(new String[0]);


        return new LotterysResponseDto(tickets);
    }

    public UserTicketResponseDto deleteUserTicket(String userId, String ticketId) {

        userTicketRepository.deleteById(Long.valueOf(ticketId));
        return new UserTicketResponseDto(userId);
    }
}
