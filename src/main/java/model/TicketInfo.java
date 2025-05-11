/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class TicketInfo {
    private String routeNumber;
    private String origin;
    private String destination;
    private int price;


    public TicketInfo(String routeNumber, String origin, String destination, int price) {
        this.routeNumber = routeNumber;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    public String getRouteNumber() { return routeNumber; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }

    public int getPrice() { return price; }


    public void setRouteNumber(String routeNumber) { this.routeNumber = routeNumber; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setDestination(String destination) { this.destination = destination; }

    public void setPrice(int price) { this.price = price; }

}

