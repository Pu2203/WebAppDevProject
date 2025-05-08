/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huynh
 */
public class Schedule {
    private int scheduleId;
    private String routeId;
    private java.time.LocalDate date;
    private java.time.LocalTime startTime;
    private java.time.LocalTime endTime;
    
    //Constructor
    public Schedule(int scheduleId, String routeId, java.time.LocalDate date, java.time.LocalTime startTime, java.time.LocalTime endTime){
        this.scheduleId = scheduleId;
        this.routeId = routeId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    // Getters
    public int getScheduleId() {
        return scheduleId;
    }
    
    public String getRouteId() {
        return routeId;
    }
    
    public java.time.LocalDate getDate() {
        return date;
    }
    
    public java.time.LocalTime getStartTime() {
        return startTime;
    }
    
    public java.time.LocalTime getEndTime() {
        return endTime;
    }
    
    // Setters
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
    
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
    
    public void setDate(java.time.LocalDate date) {
        this.date = date;
    }
    
    public void setStartTime(java.time.LocalTime startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(java.time.LocalTime endTime) {
        this.endTime = endTime;
    }
}