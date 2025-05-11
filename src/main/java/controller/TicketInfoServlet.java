/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.sql.*;
import java.util.*;
import DAO.TicketDB;
import DAO.DBConnection;
import model.TicketInfo; // Ensure this matches the actual package of the TicketInfo class


/**
 *
 * @author ADMIN
 */
@WebServlet(name = "TicketInfoServlet", urlPatterns = {"/TicketInfoServlet"})
public class TicketInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try (Connection conn = DBConnection.getConnection()) {
            TicketDB ticketDB = new TicketDB();
            List<TicketInfo> ticketList = ticketDB.getAllTicketInfo();
            HttpSession session = request.getSession();
            
            // Set the ticket list as a session attribute
            session.setAttribute("ticketList", ticketList);

            // Forward to the JSP page
            request.getRequestDispatcher("/views/view_buses.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error loading ticket info", e);
        }
    }
}
