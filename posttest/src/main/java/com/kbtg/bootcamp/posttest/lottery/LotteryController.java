package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.request.LotteryRequest;
import com.kbtg.bootcamp.posttest.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class LotteryController {

    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }
    @GetMapping("/lotteries")
    public LotterysResponse getTicket() {
        return this.lotteryService.getTicketLotteries();
    }

    @PostMapping("/admin/lotteries")
    public ResponseEntity postTicket(@RequestBody LotteryRequest lotteryRequest) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(lotteryService.createLottery(lotteryRequest));
    }

    @PostMapping("/users/{userId}/lotteries/{ticketId}")
    public ResponseEntity postUserId(@PathVariable String userId, @PathVariable String ticketId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(lotteryService.createUserTicket(userId, ticketId));
    }
    @DeleteMapping("/users/{userId}/lotteries/{ticketId}")
    public DeleteTicketResponse deleteUserTicket(@PathVariable String userId, @PathVariable String ticketId) {
        return lotteryService.deleteUserTicket(userId, ticketId);
    }
    @GetMapping("/users/{userId}/lotteries")
    public UserTicketResponse getAllLotteryTicketsByUser(@PathVariable String userId) {
        return lotteryService.findByUserId(userId);
    }
}
