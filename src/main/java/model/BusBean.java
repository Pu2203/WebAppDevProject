/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huynh
 */
public class BusBean {
    private int busId;
    private int busNum;
    private int avaiSeat;
    
    //Constructor
    public BusBean(int busId, int busNum, int avaiSeat){
        this.busId = busId;
        this.busNum = busNum;
        this.avaiSeat = avaiSeat;
    }
    
    // Getters
    public int getBusId() {
        return busId;
    }
    
    public int getBusNum() {
        return busNum;
    }
    
    public int getAvaiSeat() {
        return avaiSeat;
    }
    
    // Setters
    public void setBusId(int busId) {
        this.busId = busId;
    }
    
    public void setBusNum(String routeId) {
        this.busNum = busNum;
    }
    
    public void setAvaiSeat(String licensePlate) {
        this.avaiSeat = avaiSeat;
    }
   
}

