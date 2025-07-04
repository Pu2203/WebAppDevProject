/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.CartTicket;
import model.Payment;
import model.PaymentTicket;
import model.TicketInfo;

public class CartDB {

    public static void addPayment(Payment payment) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO Cart (account_id, payment_id, cart_status, cart_type) "
                    + "VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, payment.getUserId());
            pstmt.setInt(2, payment.getPaymentId()); // Use getPassId() instead of getPaymentId()
            pstmt.setString(3, "Valid");
            pstmt.setString(4, (payment.getPassId() == 1) ? "Monthly Pass" : "Yearly Pass");

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted); // Debugging

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public static void addPaymentTicket(PaymentTicket paymentTicket) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO Cart (account_id, payment_id, cart_status, cart_type) "
                    + "VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, paymentTicket.getAccountId());
            pstmt.setInt(2, paymentTicket.getPaymentTicketId()); // Use getPassId() instead of getPaymentId()
            pstmt.setString(3, "None");
            pstmt.setString(4, "Ticket");

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted); // Debugging

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public static List<CartTicket> getCartTicket(int accountId) {
        List<CartTicket> carts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT DISTINCT c.cart_id as cartId, c.payment_id as paymentId, c.account_id as accountId, br.route_name as route, br.origin, br.destination "
                    + "FROM Cart c "
                    + "JOIN Payment p ON p.payment_id = c.payment_id "
                    + "JOIN BusRoute br ON br.ticket_id = p.ticket_id "
                    + "WHERE c.account_id = ? "
                    + "AND c.cart_type LIKE '%Ticket%'";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                CartTicket cart = new CartTicket(
                        rs.getInt("cartId"),
                        rs.getInt("paymentId"),
                        rs.getInt("accountId"),
                        rs.getString("route"),
                        rs.getString("origin"),
                        rs.getString("destination")
                );
                carts.add(cart);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return carts;
    }

    public static Cart getCartPass(int accountId) {
        Cart cart = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT c.cart_id as cart_id, c.account_id as account_id, "
                    + "c.payment_id, p.payment_date as payment_date, c.cart_type as cart_type, "
                    + "c.cart_status as cart_status, u.full_name as full_name, u.user_mail as user_email, a.account_type as account_type "
                    + "FROM Cart c "
                    + "JOIN Payment p ON p.payment_id = c.payment_id "
                    + "JOIN Account a ON a.account_id = c.account_id "
                    + "JOIN `User` u ON u.user_id = a.user_id "
                    + "WHERE c.account_id = ? "
                    + "AND cart_type LIKE '%Pass%' "
                    + "AND ((p.payment_date >= NOW() - INTERVAL 1 MONTH AND p.pass_id = 1) "
                    + "OR (p.payment_date >= NOW() - INTERVAL 1 YEAR AND p.pass_id = 2)) "
                    + "ORDER BY payment_date DESC;";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                cart = new Cart(
                        rs.getInt("cart_id"),
                        rs.getInt("account_id"),
                        rs.getInt("payment_id"),
                        rs.getDate("payment_date").toLocalDate(),
                        rs.getString("cart_type"),
                        rs.getString("cart_status"),
                        rs.getString("full_name"),
                        rs.getString("user_email"),
                        rs.getString("account_type")

                );

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return cart;
    }

    public static void deleteCart() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();

            // Delete all cart rows
            String deleteSql = "DELETE FROM Cart";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.executeUpdate();
            pstmt.close();

            // Reset auto-increment
            String alterSql = "ALTER TABLE Cart AUTO_INCREMENT = 1";
            pstmt = conn.prepareStatement(alterSql);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static boolean deleteCartByAccountId(int accountId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "DELETE FROM Cart WHERE account_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }   
}
