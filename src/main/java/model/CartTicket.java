/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huynh
 */
public class CartTicket {
    private int cartId;
    private int accountId;
    private int paymentId;
    private String route;
    private String origin;
    private String destination;
    
    //Constructor
    public CartTicket(int cartId, int paymentId, int accountId, String route, String origin, String destination){
        this.cartId = cartId;
        this.accountId = accountId;
        this.paymentId = paymentId;
        this.route = route;
        this.origin = origin;
        this.destination = destination;

    }
    
    // Getters
    public int getCartId() {
        return cartId;
    }
    
    public int getAccountId() {
        return accountId;
    }
    
    public int getPaymentId() {
        return paymentId;
    }
    
    public String getRoute(){
        return route;
    }
    
    public String getorigin() {
        return origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
    // Setters
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    
    public void setRoute(String route) {
        this.route = route;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
