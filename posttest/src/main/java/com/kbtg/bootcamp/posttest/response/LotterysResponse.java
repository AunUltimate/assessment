package com.kbtg.bootcamp.posttest.response;


public class LotterysResponse {

    private String[] tickets;


    public LotterysResponse(String[] tickets) {
        this.tickets = tickets;
    }



    public String[] getTickets() {
        return tickets;
    }
}
