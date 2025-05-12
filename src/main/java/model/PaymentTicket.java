package model;

import java.time.LocalDate;

public class PaymentTicket {

    private int paymentTicketId;
    private int accountId;
    private int ticketId;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String paymentStatus;

    // Constructor
    public PaymentTicket(int paymentTicketId, int accountId, int ticketId, LocalDate paymentDate, String paymentMethod, String paymentStatus) {
        this.paymentTicketId = paymentTicketId;
        this.accountId = accountId;
        this.ticketId = ticketId;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Getters
    public int getPaymentTicketId() {
        return paymentTicketId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Setters
    public void setPaymentTicketId(int paymentTicketId) {
        this.paymentTicketId = paymentTicketId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
