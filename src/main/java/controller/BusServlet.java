package controller;

import java.util.HashMap;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
import model.AccountBean;
import model.UserBean;


@WebServlet("/BusServlet")
public class BusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public BusServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        switch (action) {
            case "REGISTER":
                // Save account info to session
                String fname = request.getParameter("Fullname");
                String gender = request.getParameter("Gender");
                int age = Integer.parseInt(request.getParameter("Age"));
                String role = request.getParameter("Role");
                UserBean user= new UserBean(fname, gender, age);
                session.setAttribute("user", user);
        
                
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;

            case "ADD":
                // Get product index and quantity
                int productId = Integer.parseInt(request.getParameter("productId"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));

                // Get or create cart in session
                HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
                if (cart == null) {
                    cart = new HashMap<>();
                }

                if (cart.containsKey(productId)) {
                    quantity += cart.get(productId);
                    cart.replace(productId, quantity);
                }
                cart.put(productId, quantity);

                session.setAttribute("cart", cart);
                // Forward back to products.jsp
                request.getRequestDispatcher("/products.jsp").forward(request, response);
                break;

            case "DELETE":
                // Get productId from request
                int deleteProductId = Integer.parseInt(request.getParameter("productId"));

                // Get cart from session
                HashMap<Integer, Integer> deleteCart = (HashMap<Integer, Integer>) session.getAttribute("cart");
                if (deleteCart != null && deleteCart.containsKey(deleteProductId)) {
                    // Remove the product from the cart
                    deleteCart.remove(deleteProductId);
                    // Update cart in session
                    session.setAttribute("cart", deleteCart);
                }

                // Forward back to products.jsp
                request.getRequestDispatcher("/products.jsp").forward(request, response);
                break;
                
            
            case "RETURN":
                session.setAttribute("cart", null);
                response.sendRedirect("products.jsp");
                break;
            case "LOGOUT":
                session.setAttribute("cart", null);
                response.sendRedirect("account.jsp");
                break;
//            default:
//                response.sendRedirect("index.jsp");
//                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
