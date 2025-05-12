/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.TicketInfo;

import java.util.*;

/**
 *
 * @author ADMIN
 */
public class TicketDB {
    public static void insert(TicketInfo ticket){
        
        return;
    }
    public static List<TicketInfo> getAllTicketInfo() {
        List<TicketInfo> tickets = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT r.ticket_id AS ticketId, r.route_name AS RouteNumber, r.origin as Origin, r.destination as Destination, t.ticket_price AS price " +
                        "FROM Ticket t " +
                        "JOIN BusRoute r ON t.ticket_id = r.ticket_id ";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                TicketInfo ticket = new TicketInfo(
                    rs.getInt("ticketId"),
                    rs.getString("RouteNumber"),
                    rs.getString("Origin"),
                    rs.getString("Destination"),
                    rs.getInt("price")

                );
                tickets.add(ticket);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return tickets;
    }
}