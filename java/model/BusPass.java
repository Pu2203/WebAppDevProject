/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huynh
 */
public class BusPass {
    private int passId;
    private int userId;
    private int cartId;
    private String passType;
    private float passPrice;
    private java.time.LocalDate passStatusDate;
    private java.time.LocalDate passExpiredDate;
    private String passStatus;
    
    //Constructor
    public BusPass(int passId, int userId, int cartId, String passType, float passPrice, java.time.LocalDate passStatusDate,
    java.time.LocalDate passExpiredDate, String passStatus){
        this.passId = passId;
        this.userId = userId;
        this.cartId = cartId;
        this.passType = passType;
        this.passPrice = passPrice;
        this.passStatusDate = passStatusDate;
        this.passExpiredDate = passExpiredDate;
        this.passStatus = passStatus;                
    }
    
    // Getters
    public int getPassId() {
        return passId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public int getCartId() {
        return cartId;
    }
    
    public String getPassType() {
        return passType;
    }
    
    public float getPassPrice() {
        return passPrice;
    }
    
    public java.time.LocalDate getPassStatusDate() {
        return passStatusDate;
    }
    
    public java.time.LocalDate getPassExpiredDate() {
        return passExpiredDate;
    }
    
    public String getPassStatus() {
        return passStatus;
    }
    
    // Setters
    public void setPassId(int passId) {
        this.passId = passId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    
    public void setPassType(String passType) {
        this.passType = passType;
    }
    
    public void setPassPrice(float passPrice) {
        this.passPrice = passPrice;
    }
    
    public void setPassStatusDate(java.time.LocalDate passStatusDate) {
        this.passStatusDate = passStatusDate;
    }
    
    public void setPassExpiredDate(java.time.LocalDate passExpiredDate) {
        this.passExpiredDate = passExpiredDate;
    }
    
    public void setPassStatus(String passStatus) {
        this.passStatus = passStatus;
    }
}
