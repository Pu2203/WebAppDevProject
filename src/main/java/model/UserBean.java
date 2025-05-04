/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ductrungnguyen
 */
public class UserBean {
    private int id = -1;
    private String fname;
    private String gender;
    private int age;

    public UserBean() {
        fname = "";
        gender = "";
        age = 0;
    }
    
    public UserBean(String fname, String gender, int age){
        this.fname = fname;
        this.gender = gender;
        this.age = age;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
