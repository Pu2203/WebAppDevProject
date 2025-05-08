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
public class User {
     private int userId;
    private String userName;
    private String userPassword;
    private String accountType;
    private int userPhonenumber;
    private String userEmail;
    private String gender;
    private LocalDate dob;
    private float balance;
    
    //Constructor
    public User(int userId, String userName, String userPassword, String accountType,
            int userPhonenumber, String userEmail, String gender, LocalDate dob, float balance) {
    this.userId = userId;
    this.userName = userName;
    this.userPassword = userPassword;
    this.accountType = accountType;
    this.userPhonenumber = userPhonenumber;
    this.userEmail = userEmail;
    this.gender = gender;
    this.dob = dob;
    this.balance = balance;
}
    
    // Getters
    public int getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public int getUserPhonenumber() {
        return userPhonenumber;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    
    public String getGender() {
        return gender;
    }
    
    public LocalDate getDob() {
        return dob;
    }
    
    public float getBalance() {
        return balance;
    }
    
    // Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public void setUserPhonenumber(int userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
}
