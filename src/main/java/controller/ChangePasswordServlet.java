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
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String url = "User/change_password.jsp";
        HttpSession session = request.getSession();
        AccountBean account = (AccountBean) session.getAttribute("account");
        String username = account.getUsername();
        int id = account.getId();
        String currentPass = request.getParameter("currentPass");
        String newPass = request.getParameter("newPass");
        String confPass = request.getParameter("confPass");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT *, AES_DECRYPT(password, 'TRUNTRUN') AS decryptedPassword FROM Account WHERE username = ? AND AES_DECRYPT(password, 'TRUNTRUN') = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, currentPass);

            rs = stmt.executeQuery();

            if (rs.next()) {
                if (newPass == null || confPass == null || !newPass.equals(confPass)) {
                    // Passwords don't match — set error message
                    request.setAttribute("error", "Passwords do not match. Please try again.");
                    request.getRequestDispatcher(url).forward(request, response);
                    stmt.close();
                    return;
                } else {
                    String change = "UPDATE Account SET password = AES_ENCRYPT(?,'TRUNTRUN') WHERE username = ?";
                    PreparedStatement stmtchange = null;
                    stmtchange = conn.prepareStatement(change);
                    stmtchange.setString(1, newPass);
                    stmtchange.setString(2, username);
                    stmtchange.executeUpdate();
                    account.setPassword(newPass);
                    stmtchange.close();
                    request.setAttribute("message", "Change password successful!");
                }
            } else {
                request.setAttribute("error", "Password error");
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