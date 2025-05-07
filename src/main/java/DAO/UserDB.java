/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

            String sql = "INSERT INTO User (PhoneNum, Email, FullName, Gender, Age) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getPhone());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getFname());
            pstmt.setString(4, user.getGender());
            pstmt.setInt(5, user.getAge());


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
            
    
            
    
}
