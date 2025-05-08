/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huynh
 */
public class BusRoute {
    private String routeId;
    private int passId;
    private int ticketId;
    private int routeNumber;
    private String routeName;
    private String origin;
    private String destination;
    private float distance;
    private String sequenceStop;
    private String direction;
    
    //Constructor
    public BusRoute(String routeId, int passId, int ticketId, int routeNumber, String routeName, String origin,
            String destination, float distance, String sequenceStop, String direction){
        this.routeId = routeId;
        this.passId = passId;
        this.ticketId = ticketId;
        this.routeNumber = routeNumber;
        this.routeName =routeName;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.sequenceStop = sequenceStop;
        this.direction = direction;      
    }
    
    // Getters
    public String getRouteId() {
        return routeId;
    }
    
    public int getPassId() {
        return passId;
    }
    
    public int getTicketId() {
        return ticketId;
    }
    
    public int getRouteNumber() {
        return routeNumber;
    }
    
    public String getRouteName() {
        return routeName;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public float getDistance() {
        return distance;
    }
    
    public String getSequenceStop() {
        return sequenceStop;
    }
    
    public String getDirection() {
        return direction;
    }
    
    // Setters
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
    
    public void setPassId(int passId) {
        this.passId = passId;
    }
    
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    
    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }
    
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public void setDistance(float distance) {
        this.distance = distance;
    }
    
    public void setSequenceStop(String sequenceStop) {
        this.sequenceStop = sequenceStop;
    }
    
    public void setDirection(String direction) {
        this.direction = direction;
    }
}

