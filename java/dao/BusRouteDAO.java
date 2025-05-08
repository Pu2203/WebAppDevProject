/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author huynh
 */
import model.BusRoute;
import java.sql.*;
import java.util.*;

public class BusRouteDAO {
    private final Connection connection;

    public BusRouteDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void addBusRoute(BusRoute busRoute) throws SQLException{
        String sql = "INSERT INTO bus_route (route_id, pass_id, ticket_id, route_number, route_name, origin, destination, distance, sequence_stop, direction) VALUES (̣?, ?, ?, ?, ?, ?, ?, ?, ?, ?)̣";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, busRoute.getRouteId());
            stmt.setInt(2, busRoute.getPassId());
            stmt.setInt(3, busRoute.getTicketId());
            stmt.setInt(4, busRoute.getRouteNumber());
            stmt.setString(5, busRoute.getRouteName());
            stmt.setString(6, busRoute.getOrigin());
            stmt.setString(7, busRoute.getDestination());
            stmt.setFloat(8, busRoute.getDistance());
            stmt.setString(9, busRoute.getSequenceStop());
            stmt.setString(10, busRoute.getDirection());
            stmt.executeUpdate();
        }
    }
    
    public BusRoute getBusRouteById (String routeId) throws SQLException{
        String sql = "SELECT * FROM bus_route WHERE route_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, routeId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new BusRoute(
                        rs.getString("route_id"),
                        rs.getInt("pass_id"),
                        rs.getInt("ticket_id"),
                        rs.getInt("route_number"),
                        rs.getString("route_name"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getFloat("distance"),
                        rs.getString("sequence_stop"),
                        rs.getString("direction")
                    );
                }
            }
            return null;
        }
    }
    
    public void updateBusRoute(BusRoute busRoute) throws SQLException{
        String sql = "UPDATE bus_route SET pass_id = ?, ticket_id = ?, route_number = ?, route_name = ?, origin = ?, destination = ?, distance = ?, sequence_stop = ?, direction = ? WHERE route_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, busRoute.getPassId());
            stmt.setInt(2, busRoute.getTicketId());
            stmt.setInt(3, busRoute.getRouteNumber());
            stmt.setString(4, busRoute.getRouteName());
            stmt.setString(5, busRoute.getOrigin());
            stmt.setString(6, busRoute.getDestination());
            stmt.setFloat(7, busRoute.getDistance());
            stmt.setString(8, busRoute.getSequenceStop());
            stmt.setString(9, busRoute.getDirection());
            stmt.setString(10, busRoute.getRouteId());
            stmt.executeUpdate();
        }
    }
    
    public void deleteBusRoute(String routeId) throws SQLException{
        String sql = "DELETE FROM bus_route WHERE route_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, routeId);
            stmt.executeUpdate();
        }
    }
    
    public List<BusRoute> getAllBusRoute() throws SQLException{
        List<BusRoute> busroutes = new ArrayList<>();
        String sql = "SELECT * FROM bus_route";
         try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                busroutes.add(new BusRoute(
                        rs.getString("route_id"),
                        rs.getInt("pass_id"),
                        rs.getInt("ticket_id"),
                        rs.getInt("route_number"),
                        rs.getString("route_name"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getFloat("distance"),
                        rs.getString("sequence_stop"),
                        rs.getString("direction")
                ));
            }
                 return busroutes;       
        }
    }
}
