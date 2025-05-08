/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author huynh
 */
import model.Payment;
import java.sql.*;
import java.util.*;
import java.sql.Date;

public class PaymentDAO {
     private final Connection connection;
    
    public PaymentDAO(Connection connection){
        this.connection = connection;
    }
    public void addPayment (Payment payment) throws SQLException{
        String sql = "INSERT INTO payment (payment_id, user_id, payment_method, payment_date, payment_status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, payment.getPaymentId());
            stmt.setInt(2, payment.getUserId());
            stmt.setString(3, payment.getPaymentMethod());
            stmt.setDate(4, Date.valueOf(payment.getPaymentDate()));
            stmt.setString(5, payment.getPaymentStatus());
            stmt.executeUpdate();
        }
    }
    
    public Payment getPaymenById(int paymentId) throws SQLException{
        String sql = "SELECT * FROM payment WHERE payment_id = ?";
         try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, paymentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("user_id"),
                        rs.getString("payment_method"),
                        rs.getDate("payment_date").toLocalDate(),
                        rs.getString("payment_status")
                    );
       
                   }
                return null;
            }
        }
    }
    
    public void updatePayment(Payment payment) throws SQLException{
        String sql = "UPDATE payment SET user_id = ?, payment_method = ?, payment_date = ?, payment_status = ? WHERE payment_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, payment.getUserId());
            stmt.setDate(2, Date.valueOf(payment.getPaymentDate()));
            stmt.setString(3, payment.getPaymentStatus());
            stmt.setInt(4, payment.getPaymentId());
            stmt.executeUpdate();
        }
    }
    
    public void deletePayment(int paymentId) throws SQLException{
        String sql = "DELETE FROM payment WHERE payment_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, paymentId);
            stmt.executeUpdate();
        }
    }
    
    public List<Payment> getAllPayments() throws SQLException{
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payment";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                payments.add(new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("user+id"),
                        rs.getString("payment_method"),
                        rs.getDate("payment_date").toLocalDate(),
                        rs.getString("payment_status")
                ));
                        
            }
        }
        return payments;
    }
}
