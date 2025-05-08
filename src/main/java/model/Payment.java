/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huynh
 */
public class Payment {
  private int paymentId;
    private int userId;
    private String paymentMethod;
    private java.time.LocalDate paymentDate;
    private String paymentStatus;
    
    //Constructor
    public Payment(int paymentId, int userId, String paymentMethod, java.time.LocalDate paymentDate, String paymentStatus){
        this.paymentId = paymentId;
        this.userId = userId;
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
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public java.time.LocalDate getPaymentDate() {
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
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void setPaymentDate(java.time.LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
