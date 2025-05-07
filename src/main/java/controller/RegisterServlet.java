/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.AccountDB;
import DAO.UserDB;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBean;
import model.UserBean;

/**
 *
 * @author ductrungnguyen
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        String fname = request.getParameter("Fullname");
                String gender = request.getParameter("Gender");
                int age = Integer.parseInt(request.getParameter("Age"));
                String role = request.getParameter("Role");
                String email = request.getParameter("Email");
                String phone = request.getParameter("PhoneNum");
                String username = request.getParameter("Username");
                String password = request.getParameter("Password");
                String confirmPassword = request.getParameter("ConfirmPassword");

                if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
                    // Passwords don't match — set error message
                    request.setAttribute("error", "Passwords do not match. Please try again.");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                    return;
                } 
                UserBean user = new UserBean(-1, phone, email, fname, gender, age);
                int userId = UserDB.insert(user);
                if (user.getId() == -1) user.setId(userId);
                AccountBean account = new AccountBean(-1, password, username, 0, role, userId);
                int accountId = AccountDB.insert(account);
                if (account.getId() == -1) account.setId(accountId);

                session.setAttribute("user", user);
                
                session.setAttribute("account", account);

                request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
