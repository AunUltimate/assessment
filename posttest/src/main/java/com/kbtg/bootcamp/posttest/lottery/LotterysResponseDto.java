package com.kbtg.bootcamp.posttest.lottery;


public class LotterysResponseDto {

    private String[] tickets;


    public LotterysResponseDto(String[] tickets) {
        this.tickets = tickets;
    }



    public String[] getTickets() {
        return tickets;
    }
}
