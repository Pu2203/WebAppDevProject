package model;

import java.time.LocalDate;

public class Payment {
    private int paymentId;
    private int userId;
    private int passId; // Add passId field
    private String paymentMethod;
    private LocalDate paymentDate;
    private String paymentStatus;

    // Constructor
    public Payment(int paymentId, int userId, int passId, LocalDate paymentDate, String paymentMethod, String paymentStatus) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.passId = passId; // Initialize passId
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    // Getters
    public int getPaymentId() {
        return paymentId;
    }

    public int getUserId() {
        return userId;
    }

    public int getPassId() { // Add getter for passId
        return passId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Setters
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPassId(int passId) { // Add setter for passId
        this.passId = passId;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}