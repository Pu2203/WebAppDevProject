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
    private String busNumber;
    private String route;
    private int price;
    private String type;

    public TicketInfo(String busNumber, String route, int price, String type) {
        this.busNumber = busNumber;
        this.route = route;
        this.price = price;
        this.type = type;
    }

    public String getBusNumber() { return busNumber; }
    public String getRoute() { return route; }
    public int getPrice() { return price; }
    public String getType() { return type; }

    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
    public void setRoute(String route) { this.route = route; }
    public void setPrice(int price) { this.price = price; }
    public void setType(String type) { this.type = type; }
}

