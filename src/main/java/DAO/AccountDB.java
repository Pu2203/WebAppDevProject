/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

            String sql = "INSERT INTO Account (username, password, balance, account_type, User_id) VALUES (?, AES_ENCRYPT(?,'TRUNTRUN'), ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, account.getUsername());
            pstmt.setString(2, account.getPassword());
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
    
    public static AccountBean getAccount(String username){
        AccountBean account = null;
        
        return account;
    }

    public static boolean updateBalance(int accountId, int amount) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "UPDATE Account SET balance = ? WHERE account_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, amount + DAO.AccountDB.getAccountById(accountId).getBalance()); // Add amount to current balance
            pstmt.setInt(2, accountId);

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    public static boolean deleteAccount(int accountId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "DELETE FROM Account WHERE account_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);

            // Execute the delete statements
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
    public static AccountBean getAccountById(int accountId) {
        AccountBean account = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT * FROM Account WHERE account_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                account = new AccountBean(
                        rs.getInt("account_id"),
                        rs.getString("username"),
                        rs.getString("password"), // Note: Password should be handled securely
                        rs.getInt("balance"),
                        rs.getString("account_type"),
                        rs.getInt("User_id")
                );
                
                account.setTicketCount(DAO.PaymentTicketDB.countTicketsPurchased(account.getId()));
                account.setPassId(DAO.PaymentDB.getPassId(account.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return account;
    }
    public static List<AccountBean> getAllAccounts() {
        List<AccountBean> accountList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Use DBConnection utility to get connection
            conn = DBConnection.getConnection();

            String sql = "SELECT * FROM Account";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                AccountBean account = new AccountBean(
                        rs.getInt("account_id"),
                        rs.getString("username"),
                        rs.getString("password"), // Note: Password should be handled securely
                        rs.getInt("balance"),
                        rs.getString("account_type"),
                        rs.getInt("User_id")
                );
                
                account.setTicketCount(DAO.PaymentTicketDB.countTicketsPurchased(account.getId()));
                account.setPassId(DAO.PaymentDB.getPassId(account.getId()));
                accountList.add(account);
            }
            return accountList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return null;
    }
}
