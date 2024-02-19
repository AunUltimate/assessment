package com.kbtg.bootcamp.posttest.lottery;

import java.util.Optional;

public class LotteryService {

    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }


    public String createLottery(LotteryRequest lotteryRequest) {

        return "lottery";


        
    }
}
