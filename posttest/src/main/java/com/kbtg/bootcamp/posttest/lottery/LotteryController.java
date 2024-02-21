package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class LotteryController {

    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }
    @GetMapping("/lotteries")
    public String getTicket() {

        return "lottery";
    }

    @PostMapping("/admin/lotteries")
    public LotteryResponseDto postTicket(@RequestBody LotteryRequestDto lotteryRequestDto) throws Exception {
        return this.lotteryService.createLottery(lotteryRequestDto);
    }
}
