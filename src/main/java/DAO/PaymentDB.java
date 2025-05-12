package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;

import model.Payment;

public class PaymentDB {
    public static boolean insertPayment(Payment payment) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO Payment (account_id, pass_id, payment_date, payment_method, payment_status) " +
                         "VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, payment.getUserId());
            pstmt.setInt(2, payment.getPassId()); // Use getPassId() instead of getPaymentId()
            pstmt.setDate(3, java.sql.Date.valueOf(payment.getPaymentDate()));
            pstmt.setString(4, payment.getPaymentMethod());
            pstmt.setString(5, payment.getPaymentStatus());

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
    public static Payment getPayment(int accountId){
        Payment payment = null;
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT * " +
                         "FROM Payment " +
                         "WHERE account_id = ? " +
                         "AND ((payment_date >= NOW() - INTERVAL 1 MONTH AND pass_id = 1) " +
                         "OR (payment_date >= NOW() - INTERVAL 1 YEAR AND pass_id = 2)) " +
                         "ORDER BY payment_date DESC;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                payment = new Payment(
                    rs.getInt("payment_id"),
                    rs.getInt("account_id"),
                    rs.getInt("pass_id"),
                    rs.getDate("payment_date").toLocalDate(),
                    rs.getString("payment_method"),
                    rs.getString("payment_status")
                );
            }
            } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return payment;
    }

    public static boolean hasActiveBusPass(int accountId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM Payment WHERE account_id = ? AND pass_id IS NOT NULL AND payment_date + INTERVAL 1 MONTH >= ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);
            pstmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Return true if there is an active bus pass
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return false;
    }
    
}