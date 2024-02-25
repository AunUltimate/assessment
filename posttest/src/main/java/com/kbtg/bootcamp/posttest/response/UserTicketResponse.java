package com.kbtg.bootcamp.posttest.response;

public class UserTicketResponse {
    private String[] tickets;

    private String count;
    private String cost;

    public UserTicketResponse(String[] tickets, String count, String cost) {
        this.tickets = tickets;
        this.count = count;
        this.cost = cost;
    }

    public String[] getTickets() {
        return tickets;
    }

    public String getCount() {
        return count;
    }

    public String getCost() {
        return cost;
    }
}
