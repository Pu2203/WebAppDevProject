package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import DAO.AccountDB;
import DAO.CartDB;
import DAO.PaymentDB;
import model.AccountBean;
import model.Payment;
import model.UserBean;

@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        int price = Integer.parseInt(request.getParameter("price"));

        // Get the logged-in user's account from the session
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user != null) {
            // Retrieve the AccountBean from the session
            AccountBean userAccount = (AccountBean) session.getAttribute("account");

            if (userAccount != null) {
                // Check if the user already has an active bus pass
                boolean hasActiveBusPass = PaymentDB.hasActiveBusPass(userAccount.getId());
                if (hasActiveBusPass) {
                    // Redirect to failure page if the user already has an active bus pass
                    request.setAttribute("message", "You already have an active bus pass. You can only purchase a new one after the current pass expires.");
                    request.getRequestDispatcher("/views/payment_failure.jsp").forward(request, response);
                    return;
                }

                int currentBalance = userAccount.getBalance();

                if (currentBalance >= price) {
                    // Deduct the price from the user's balance
                    int amount = -price;
                    
                    
                    // Update the balance in the database
                    int newBalance = AccountDB.updateBalance(userAccount.getId(), amount);
                    userAccount.setBalance(newBalance); // Update the balance in the AccountBean
                    if (newBalance > 0) {
                        
                        // Insert payment information into the database
                        Payment payment = new Payment(
                            0, // paymentId (auto-generated)
                            userAccount.getId(), // account_id
                            type.equals("Monthly") ? 1 : 2, // pass_id (1 for OneMonth, 2 for OneYear)
                            LocalDate.now(), // payment_date
                            "Balance", // payment_method
                            "Success" // payment_status
                        );
                        
                        boolean isPaymentInserted = PaymentDB.insertPayment(payment);
                        
                        if (isPaymentInserted) {
                            // Update the session with the new balance
                            session.setAttribute("account", userAccount);

                            // Redirect to success page
                            request.setAttribute("message", "Payment successful! You purchased a " + type + " pass.");
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