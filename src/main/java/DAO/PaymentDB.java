package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;

import model.Payment;
import model.TicketInfo;

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
            pstmt.setDate(3, payment.getPaymentDate());
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
    public static Payment getPayment(int accountId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = DBConnection.getConnection();

            String sql = "Select * From Payment WHERE account_id = ?";
            pstmt.setInt(1, accountId);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Payment pass = new Payment(rs.getInt("payment_id"),
                    rs.getInt("account_id"),
                    rs.getInt("pass_id"),
                    rs.getDate("payment_date"),
                    rs.getString("payment_method"),
                    rs.getString("payment_status")

                );
                return pass;
               
            }
        } catch (Exception e) {
            e.printStackTrace();            
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return null;
    }
}