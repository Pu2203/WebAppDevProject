/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AccountBean;

@WebServlet(name = "UpdateBalanceServlet", urlPatterns = {"/UpdateBalanceServlet"})
public class UpdateBalanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message;
        try {
            int accountId = Integer.parseInt(request.getParameter("accountId"));
            int amount = Integer.parseInt(request.getParameter("newBalance"));

            int newBalance = DAO.AccountDB.updateBalance(accountId, amount);
            
            if (newBalance > 0) {
                AccountBean account = (AccountBean) request.getSession().getAttribute("account");
                if (accountId == account.getId()){
                    account.setBalance(newBalance);
                    request.getSession().setAttribute("account", account);
                }
                message =String.format("Balance of acount ID: %d updated to %d successfully.", accountId, newBalance);
            } else {
                message = "Failed to update balance. Please try again.";
            }
        } catch (Exception e) {
            message = "Invalid input. Please enter a valid number.";
        }
               request.getSession().setAttribute("message", message);
        response.sendRedirect(request.getContextPath() + "/AdminServlet");
    }
}
