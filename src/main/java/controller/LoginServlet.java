/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.DBConnection;
import DAO.AccountDB;
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
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        if (action != null && action.equals("LOGOUT")) {
            // Xử lý đăng xuất
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();

            // Truy vấn thông tin tài khoản
            String sql = "SELECT * FROM Account WHERE Username = ? AND Password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {
                int accountId = rs.getInt("id");
                String role = rs.getString("Role");
                int userId = rs.getInt("UserId");
                
                // Tạo đối tượng AccountBean
                AccountBean account = new AccountBean(accountId, username, password, 0, role, userId);
                
                // Lấy thông tin user từ UserDB
                UserBean user = UserDB.findById(userId);
                
                if (user != null) {
                    // Lưu thông tin vào session
                    session.setAttribute("user", user);
                    session.setAttribute("account", account);
                    
                    // Redirect về trang chủ sau khi đăng nhập thành công
                    request.setAttribute("message", "Đăng nhập thành công! Xin chào, " + user.getFullname() + ".");
                    response.sendRedirect(request.getContextPath() + "/home");
                    return;
                } else {
                    request.setAttribute("error", "Không tìm thấy thông tin người dùng.");
                }
            } else {
                request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        // Forward back to login.jsp with message or error
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action != null && action.equals("LOGOUT")) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            doPost(request, response);
        }
    }
}
    


