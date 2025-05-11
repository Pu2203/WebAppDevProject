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
    public List<TicketInfo> getAllTicketInfo() {
        List<TicketInfo> tickets = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT b.license_plate AS busNumber, r.route_name AS route, t.ticket_price AS price " +
                        "FROM Ticket t " +
                        "JOIN BusRoute r ON t.ticket_id = r.ticket_id " +
                        "JOIN Bus b ON r.route_id = b.route_id";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                TicketInfo ticket = new TicketInfo(
                    rs.getString("busNumber"),
                    rs.getString("route"),
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