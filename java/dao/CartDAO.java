/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author huynh
 */
import model.Cart;
import java.sql.*;
import java.util.*;


public class CartDAO {
     private final Connection connection;
    
    public CartDAO(Connection connection){
        this.connection = connection;
    }
    
    public void addCart(Cart cart) throws SQLException{
        String sql = "INSERT INTO cart (cart_id, user_id, cart_status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cart.getCartId());
            stmt.setInt(2, cart.getUserId());
            stmt.setString(3, cart.getCartStatus());
            stmt.executeUpdate();
        }
    }
    
    public Cart getCartById(int cartId) throws SQLException{
        String sql = "SELECT * FROM cart WHERE cart_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cartId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cart(
                    rs.getInt("cart_id"),
                    rs.getInt("user_id"),
                    rs.getString("cart_status")
                    );
                }
                return null;
            }   
        }
    }
    
    public void updateCart(Cart cart) throws SQLException{
        String sql = "UPDATE cart SET user_id =?, cart_status = ? WHERE cart_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, cart.getUserId());
        stmt.setString(2, cart.getCartStatus());
        stmt.setInt(3, cart.getCartId());
        stmt.executeUpdate();
        }
    }
    
    public void deleteCart(int cartId) throws SQLException{
        String sql = "DELETE FROM cart WHERE cart_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, cartId);
                stmt.executeUpdate();
        }
    }
    
    public List<Cart> getAllCarts() throws SQLException{
        List<Cart> carts = new ArrayList<>();
        String sql = "SELECT * FROM cart";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                carts.add(new Cart(
                        rs.getInt("cart_id"),
                        rs.getInt("user_id"),
                        rs.getString("cart_status")
                ));     
            }
        }
        return carts;
    }
}