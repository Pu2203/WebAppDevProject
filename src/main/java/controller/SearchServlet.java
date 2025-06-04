/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.TicketDB;
import Utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.TicketInfo;

/**
 *
 * @author ductr
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();

        List<TicketInfo> ticketList = TicketDB.getAllTicketInfo(); // hoặc lấy từ DB

        // Lấy tham số sort_by từ request
        String searchQuery = request.getParameter("search_query");
        String sortBy = request.getParameter("sort_by");
        List<TicketInfo> filteredList = new ArrayList<>();
        
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            // Loại bỏ dấu trong searchQuery
            String searchQueryLower = Utils.removeAccents(searchQuery.toLowerCase());

            for (TicketInfo ticket : ticketList) {
                // Loại bỏ dấu trong origin và destination, và chuyển về lowercase
                String origin = Utils.removeAccents(ticket.getOrigin().toLowerCase());
                String destination = Utils.removeAccents(ticket.getDestination().toLowerCase());
                String routeNumber = Utils.removeAccents(ticket.getRouteNumber().toLowerCase());
                // So sánh không phân biệt dấu và chữ hoa chữ thường
                if (origin.contains(searchQueryLower) || destination.contains(searchQueryLower) || routeNumber.contains(searchQueryLower)) {
                    filteredList.add(ticket);
                }
            }
        } else {
            // Nếu searchQuery rỗng, hiển thị tất cả ticket
            filteredList = ticketList;
        }
        // Sắp xếp nếu có tham số sort_by
        if (sortBy != null) {
            switch (sortBy) {
                case "OnD":
                    ticketList.sort(Comparator.comparing(TicketInfo::getOrigin).thenComparing(TicketInfo::getDestination));
                    break;
                case "Route":
                    ticketList.sort(Comparator.comparing(TicketInfo::getRouteNumber));
                    break;
                default:
                    // Không sắp xếp gì nếu sort_by không hợp lệ
                    break;
            }
        }   
        // Set list vào session hoặc request
        request.getSession().setAttribute("ticketList", filteredList);

        // Forward về JSP
        request.getRequestDispatcher("/view_bus/view_buses.jsp").forward(request, response);
    }
}
