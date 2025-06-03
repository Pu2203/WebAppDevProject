/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AccountBean;
import model.UserBean;

/**
 *
 * @author ductr
 */
@WebServlet(name = "DeleteAccountServlet", urlPatterns = {"/DeleteAccountServlet"})
public class DeleteAccountServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteAccountServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteAccountServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        // Forward to the delete account page
        request.getRequestDispatcher("/views/manage.jsp").forward(request, response);   
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
        AccountBean currentAccount = (AccountBean) request.getSession().getAttribute("account");
        String message;
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        if (currentAccount != null && currentAccount.getId() == accountId) {
            // If the account is not found or does not match the current session, redirect to an error page
            request.getSession().setAttribute("message", "Cannot Delete account while logged in. Please log out first.");
            response.sendRedirect(request.getContextPath() + "/AdminServlet");
            return;
        }
        AccountBean account = DAO.AccountDB.getAccountById(accountId);
        int userId = account.getUserId();
        boolean CartDeleted = DAO.CartDB.deleteCartByAccountId(accountId);
        boolean PaymentDeleted = DAO.PaymentDB.deletePaymentByAccountId(accountId);
        boolean AccountDelete = DAO.AccountDB.deleteAccount(accountId);
        boolean UserDeleted = DAO.UserDB.deleteUser(userId);

        
        if (UserDeleted && AccountDelete) {
            message = "Account deleted successfully.";
        } else {
            message = "Failed to delete account. Please try again.";
        }
        // Store message in session or as a URL parameter if you want to show it on manage.jsp
        request.getSession().setAttribute("message", message);

        // Redirect to AdminServlet to refresh the user/account list
        response.sendRedirect(request.getContextPath() + "/AdminServlet");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
