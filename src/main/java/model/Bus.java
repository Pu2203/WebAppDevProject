/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huynh
 */
public class Bus {
    private int busId;
    private String routeId;
    private String licensePlate;
    private String model;
    private int year;
    private int capacity;
    private String busStatus;
    
    //Constructor
    public Bus(int busId, String routeId, String licensePlate, String model, int year,
        int capacity, String busStatus){
        this.busId = busId;
        this.routeId = routeId;
        this.licensePlate = licensePlate;
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.busStatus = busStatus;
    }
    
    // Getters
    public int getBusId() {
        return busId;
    }
    
    public String getRouteId() {
        return routeId;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public String getBusStatus() {
        return busStatus;
    }
    
    // Setters
    public void setBusId(int busId) {
        this.busId = busId;
    }
    
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void setBusStatus(String busStatus) {
        this.busStatus = busStatus;
    }
}

