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
    public LotterysResponseDto getTicket() {

        return this.lotteryService.getTicketLotteries();
    }

    @PostMapping("/admin/lotteries")
    public LotteryResponseDto postTicket(@RequestBody LotteryRequestDto lotteryRequestDto) throws Exception {
        return this.lotteryService.createLottery(lotteryRequestDto);
    }

    @PostMapping("/users/{userId}/lotteries/{ticketId}")
    public UserTicketResponseDto postUserId(@PathVariable String userId, @PathVariable String ticketId) {

        return this.lotteryService.createUserTicket(userId, ticketId);
    }
    @DeleteMapping("/users/{userId}/lotteries/{ticketId}")
    public UserTicketResponseDto deleteUserTicket(@PathVariable String userId, @PathVariable String ticketId) {
        return lotteryService.deleteUserTicket(userId, ticketId);
    }
}
