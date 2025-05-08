/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huynh
 */
public class Cart {
 private int cartId;
    private int userId;
    private String cartStatus;
    
    //Constructor
    public Cart(int cartId, int userId, String cartStatus){
        this.cartId = cartId;
        this.userId= userId;
        this.cartStatus = cartStatus;
    }
    
    // Getters
    public int getCartId() {
        return cartId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public String getCartStatus() {
        return cartStatus;
    }
    
    // Setters
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }
}
