/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.UserBean;

/**
 *
 * @author ductrungnguyen
 */
public class UserDB {
    public static int insert(UserBean user){
        int userId = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO User (full_name, DoB, gender, user_mail, user_phone_number) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getFname());
            pstmt.setDate(2, user.getDob());
            pstmt.setString(3, user.getGender());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhone());


            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    userId = generatedKeys.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (generatedKeys != null) generatedKeys.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return userId;
    }
            
    public static UserBean getUser(int userId){
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT * FROM User WHERE user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()){
                UserBean user = new UserBean(rs.getInt("user_id"), rs.getString("user_phone_number"), 
                        rs.getString("user_mail"), rs.getString("full_name"), rs.getString("gender"), rs.getDate("DoB"));
                return user;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return null;
    }
       
    public static List<UserBean> getAllUsers() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<UserBean> userList = new java.util.ArrayList<>();
        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT * FROM User";
            pstmt = conn.prepareStatement(sql);
            
            rs = pstmt.executeQuery();
            while (rs.next()){
                UserBean user = new UserBean(rs.getInt("user_id"), rs.getString("user_phone_number"), 
                        rs.getString("user_mail"), rs.getString("full_name"), rs.getString("gender"), rs.getDate("DoB"));
                userList.add(user);
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return null;
    }
    public static boolean deleteUser(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "DELETE FROM User WHERE user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return false;
    }

    public static boolean updateBalance(int userId, int amount) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "UPDATE User SET balance = ? WHERE user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, amount);
            pstmt.setInt(2, userId);

            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0;
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        } 
        return false;      
    }
}