package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import DAO.AccountDB;
import DAO.CartDB;
import DAO.PaymentTicketDB;
import model.AccountBean;
import model.PaymentTicket;
import model.UserBean;

@WebServlet(name = "PaymentTicketServlet", urlPatterns = {"/PaymentTicketServlet"})
public class PaymentTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int price = Integer.parseInt(request.getParameter("price"));
        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        // Get the logged-in user's account from the session
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        
        if (user != null) {
            // Retrieve the AccountBean from the session
            AccountBean userAccount = (AccountBean) session.getAttribute("account");

            if (userAccount != null) {
                int currentBalance = userAccount.getBalance();

                if (currentBalance >= price) {
                    // Deduct the price from the user's balance
                    int newBalance = currentBalance - price;
                    userAccount.setBalance(newBalance);

                    // Update the balance in the database
                    boolean isUpdated = AccountDB.updateBalance(userAccount.getId(), newBalance);

                    if (isUpdated) {
                        // Insert ticket payment information into the database
                        PaymentTicket paymentTicket = new PaymentTicket(
                            0, // paymentTicketId (auto-generated)
                               userAccount.getId(), // account_id 
                            ticketId,// ticket_id
                            LocalDate.now(), // payment_date
                            "Balance", // payment_method
                            "Success" // payment_status
                        );
                        
                        boolean isPaymentInserted = PaymentTicketDB.insertPaymentTicket(paymentTicket);
                        
                        
                        if (isPaymentInserted) {
                            // Update the session with the new balance
                            session.setAttribute("account", userAccount);

                            // Redirect to success page
                            request.setAttribute("message", "Payment successful! You purchased a ticket.");
                            request.getRequestDispatcher("/views/payment_success.jsp").forward(request, response);
                        } else {
                            // Redirect to failure page if payment insertion fails
                            request.setAttribute("message", "Payment failed due to a system error. Please try again.");
                            request.getRequestDispatcher("/views/payment_failure.jsp").forward(request, response);
                        }
                    } else {
                        // Redirect to failure page if balance update fails
                        request.setAttribute("message", "Payment failed due to a system error. Please try again.");
                        request.getRequestDispatcher("/views/payment_failure.jsp").forward(request, response);
                    }
                } else {
                    // Redirect to failure page if insufficient balance
                    request.setAttribute("message", "Insufficient balance. Please top up your account.");
                    request.getRequestDispatcher("/views/payment_failure.jsp").forward(request, response);
                }
            } else {
                // Redirect to failure page if account is not found
                request.setAttribute("message", "Account not found. Please contact support.");
                request.getRequestDispatcher("/views/payment_failure.jsp").forward(request, response);
            }
        } else {
            // Redirect to login page if user is not logged in
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}