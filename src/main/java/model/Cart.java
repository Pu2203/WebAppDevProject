/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author huynh
 */
public class Cart {

    private int cartId;
    private int accountId;
    private int paymentId;
    private LocalDate date;
    private LocalDate expiredDate;
    private String cartType;
    private String cartStatus;
    private String fname;
    private String email;
    private String accountType;

    //Constructor
    public Cart(int cartId, int accountId, int paymentId, LocalDate date, String cartType, String cartStatus, String fname, String email, String accountType) {
        this.cartId = cartId;
        this.accountId = accountId;
        this.paymentId = paymentId;
        this.date = date;
        this.cartType = cartType;
        this.cartStatus = cartStatus;
        this.fname = fname;
        this.email = email;
        this.accountType = accountType;
        if (cartType.equals("Yearly Pass")) {
            expiredDate = date.plusDays(365);
        } else if (cartType.equals("Monthly Pass")) {
            expiredDate = date.plusDays(30);
        }
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

    public String getCartType() {
        return cartType;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public LocalDate getDate() {
        return date;
    }
    public LocalDate getExpiredDate() {
        return expiredDate;
    }
    public String getFname() {
        return fname;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountType() {
        return accountType;
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

    public void setCartType(String cartType) {
        this.cartType = cartType;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }
}
