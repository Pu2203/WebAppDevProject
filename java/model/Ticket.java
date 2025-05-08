/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;


public class Ticket {
    private int ticketId;
    private int userId;
    private int cartId;
    private String ticketType;
    private float ticketPrice;
    private LocalDate ticketStatusDate;
    private LocalDate ticketExpiredDate;
    private String ticketStatus;
    
    //Contructor
    public Ticket(int ticketId, int userId, int cartId, String ticketType, float ticketPrice, 
           LocalDate ticketStatusDate, LocalDate ticketExpiredDate, String ticketStatus){
        
    }
    // Getters
    public int getTicketId() {
        return ticketId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public int getCartId() {
        return cartId;
    }
    
    public String getTicketType() {
        return ticketType;
    }
    
    public float getTicketPrice() {
        return ticketPrice;
    }
    
    public LocalDate getTicketStatusDate() {
        return ticketStatusDate;
    }
    
    public LocalDate getTicketExpiredDate() {
        return ticketExpiredDate;
    }
    
    public String getTicketStatus() {
        return ticketStatus;
    }
    
    // Setters
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    
    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    
    public void setTicketStatusDate(LocalDate ticketStatusDate) {
        this.ticketStatusDate = ticketStatusDate;
    }
    
    public void setTicketExpiredDate(LocalDate ticketExpiredDate) {
        this.ticketExpiredDate = ticketExpiredDate;
    }
    
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
