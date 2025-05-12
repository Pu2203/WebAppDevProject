package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Payment;
import model.PaymentTicket;

public class PaymentTicketDB {
    public static boolean insertPaymentTicket(PaymentTicket paymentTicket) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO Payment (account_id, ticket_id, payment_date, payment_method, payment_status) " +
                         "VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, paymentTicket.getAccountId());
            pstmt.setInt(2, paymentTicket.getTicketId());
            pstmt.setDate(3, java.sql.Date.valueOf(paymentTicket.getPaymentDate()));
            pstmt.setString(4, paymentTicket.getPaymentMethod());
            pstmt.setString(5, paymentTicket.getPaymentStatus());

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted); // Debugging
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    public static List<PaymentTicket> getPaymentTicket(int accountId){
        List<PaymentTicket> paymentTickets = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT * " +
                         "FROM Payment " +
                         "WHERE account_id = ? " +
                         "AND ticket_id IS NOT NULL";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                PaymentTicket paymentTicket = new PaymentTicket(
                    rs.getInt("payment_id"),
                    rs.getInt("account_id"),
                    rs.getInt("ticket_id"),
                    rs.getDate("payment_date").toLocalDate(),
                    rs.getString("payment_method"),
                    rs.getString("payment_status")
                );
                
               paymentTickets.add(paymentTicket);
            }
            } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return paymentTickets;
    }
}