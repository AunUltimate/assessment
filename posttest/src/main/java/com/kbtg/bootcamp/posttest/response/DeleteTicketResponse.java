package com.kbtg.bootcamp.posttest.response;

public class DeleteTicketResponse {
    private String ticket;


    public DeleteTicketResponse(String ticket) {
        this.ticket = ticket;
    }

    public String getTicket() {
        return ticket;
    }
}
