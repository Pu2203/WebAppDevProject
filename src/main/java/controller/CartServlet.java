/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CartDB;
import DAO.PaymentDB;
import DAO.PaymentTicketDB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.AccountBean;
import model.Cart;
import model.CartTicket;
import model.Payment;
import model.PaymentTicket;

/**
 *
 * @author ductr
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        AccountBean account = (AccountBean) session.getAttribute("account");
        int accountId = account.getId();
        Payment pass = PaymentDB.getPayment(accountId);
        Cart getPass = CartDB.getCartPass(accountId);
        List <CartTicket> getTickets= CartDB.getCartTicket(accountId);
        
        session.setAttribute("getPass", getPass);
        session.setAttribute("getTickets", getTickets);
         response.sendRedirect(request.getContextPath() + "/views/my_tickets.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}