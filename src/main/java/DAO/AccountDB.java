/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.AccountBean;

/**
 *
 * @author ductrungnguyen
 */
public class AccountDB {
    public static int insert(AccountBean account){
        int accountId = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO Account (Password, Username, Balance, Role, UserID) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, account.getPassword());
            pstmt.setString(2, account.getUsername());
            pstmt.setInt(3, account.getBalance());
            pstmt.setString(4, account.getRole());
            pstmt.setInt(5, account.getUserId());


            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    accountId = generatedKeys.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (generatedKeys != null) generatedKeys.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return accountId;
    }
}
