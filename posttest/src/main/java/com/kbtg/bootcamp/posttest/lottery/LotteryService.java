package com.kbtg.bootcamp.posttest.lottery;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LotteryService {

    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }


    public LotteryResponseDto createLottery(LotteryRequestDto lotteryRequestDto) {
        LotteryEntity lottery = new LotteryEntity();
        lottery.setTicket(lotteryRequestDto.getTicket());
        lottery.setPrice(lotteryRequestDto.getAmount());
        lottery.setAmount(lotteryRequestDto.getPrice());
        lotteryRepository.save(lottery);
        return new LotteryResponseDto(lottery.getTicket());
    }
}
