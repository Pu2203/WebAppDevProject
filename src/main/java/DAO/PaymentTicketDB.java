package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
}