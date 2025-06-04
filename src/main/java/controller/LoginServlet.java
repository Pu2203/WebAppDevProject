/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.DBConnection;
import DAO.UserDB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AccountBean;
import model.UserBean;

/**
 *
 * @author ductrungnguyen
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String url = "User/login.jsp";
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();

            String sql = "SELECT *, AES_DECRYPT(password, 'TRUNTRUN') AS decryptedPassword FROM Account WHERE username = ? AND AES_DECRYPT(password, 'TRUNTRUN') = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {
                AccountBean account = new AccountBean(rs.getInt("account_id"), rs.getString("username"), rs.getString("decryptedPassword"), rs.getInt("balance"), rs.getString("account_type"), rs.getInt("user_id"));
                session.setAttribute("account", account);
                UserBean user = UserDB.getUser(account.getUserId());
                if (user != null)
                    session.setAttribute("user", user);
                url = "home.jsp";
                request.setAttribute("message", "Login successful! Welcome, " + username + ".");
                
            } else {
                request.setAttribute("error", "Invalid username or password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        // Forward back to login.jsp with message or error
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
    


