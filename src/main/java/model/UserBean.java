/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ductrungnguyen
 */
public class UserBean {
    private int id;
    private String phone;
    private String email;
    private String fname;
    private String gender;
    private Date dob;

    public UserBean() {
        fname = "";
        gender = "";
        dob = null;
    }
    
    public UserBean(int id, String phone, String email, String fname, String gender, Date dob){
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.fname = fname;
        this.gender = gender;
        this.dob = dob;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
}
