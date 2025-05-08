/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Bus;
import java.sql.*;
import java.util.*;
 
public class BusDAO {
    private final Connection connection;
    
    public BusDAO(Connection connection){
        this.connection = connection;
    }
    
    public void addBus(Bus bus)throws SQLException{
        String sql = "INSERT INTO bus (bus_id, route_id, license_plate, model, year, capacity, bus_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
              stmt.setInt(1, bus.getBusId());
              stmt.setString(2, bus.getRouteId());
              stmt.setString(3, bus.getLicensePlate());
              stmt.setString(4, bus.getModel());
              stmt.setInt(5, bus.getYear());
              stmt.setInt(6, bus.getCapacity());
              stmt.setString(7, bus.getBusStatus());
              stmt.executeUpdate(); 
         }
    }
    
    public Bus getBusById(int busId) throws SQLException{
        String sql = "SELECT * FROM bus WHERE bus_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, busId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                     return new Bus(
                        rs.getInt("bus_id"),
                        rs.getString("route_id"),
                        rs.getString("license_plate"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getInt("capacity"),
                        rs.getString("bus_status")
                    );
            }
        }
        return null;
    }
    }
    
    public void updateBus(Bus bus) throws SQLException{
        String sql = "UPDATE bus SET route_id = ?, license_plate = ?, model = ?, year = ?, capacity = ? bus_status =? WHERE bus_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {  
            stmt.setString(1, bus.getRouteId());
            stmt.setString(2, bus.getLicensePlate());
            stmt.setString(3, bus.getModel());
            stmt.setInt(4, bus.getYear());
            stmt.setInt(5, bus.getCapacity());
            stmt.setString(6, bus.getBusStatus());
            stmt.setInt(7, bus.getBusId());
            stmt.executeUpdate();
        } 
    }
    
    public void deleteBus(int busId)throws SQLException{
        String sql = "DELETE FROM bus WHERE bus_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, busId);
            stmt.executeUpdate();
        }    
    }
    
    public List<Bus> getAllBuses() throws SQLException{
        List<Bus> buses = new ArrayList<>();
        String sql = "SELECT * FROM bus";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                buses.add(new Bus(
                        rs.getInt("bus_id"),
                        rs.getString("route_id"),
                        rs.getString("license_plate"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getInt("capacity"),
                        rs.getString("bus_status")
                ));
            }
        }
        return buses;
    }
}

