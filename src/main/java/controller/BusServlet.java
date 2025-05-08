package controller;

import DAO.UserDB;
import java.util.HashMap;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
import model.AccountBean;
import model.UserBean;
import model.BusRoute;
import model.TicketBean;
import java.sql.Date;

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
        
        if (action == null) {
            response.sendRedirect("home");
            return;
        }
        
        switch (action) {
            case "ADD_TO_CART":
                // Thêm vé vào giỏ hàng
                int routeId = Integer.parseInt(request.getParameter("routeId"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                String date = request.getParameter("date");

                // Lấy hoặc tạo giỏ hàng trong session
                HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
                if (cart == null) {
                    cart = new HashMap<>();
                }

                if (cart.containsKey(routeId)) {
                    quantity += cart.get(routeId);
                    cart.replace(routeId, quantity);
                }
                cart.put(routeId, quantity);

                session.setAttribute("cart", cart);
                session.setAttribute("bookingDate", date);
                
                // Chuyển hướng đến trang thanh toán
                response.sendRedirect(request.getContextPath() + "/account.jsp");
                break;

            case "REMOVE_FROM_CART":
                // Xóa vé khỏi giỏ hàng
                int removeRouteId = Integer.parseInt(request.getParameter("routeId"));

                HashMap<Integer, Integer> deleteCart = (HashMap<Integer, Integer>) session.getAttribute("cart");
                if (deleteCart != null && deleteCart.containsKey(removeRouteId)) {
                    deleteCart.remove(removeRouteId);
                    session.setAttribute("cart", deleteCart);
                }

                response.sendRedirect(request.getContextPath() + "/account.jsp");
                break;

            case "PAYMENT":
                // Xử lý thanh toán
                UserBean user = (UserBean) session.getAttribute("user");
                if (user == null) {
                    // Chưa đăng nhập, chuyển hướng đến trang đăng nhập
                    request.setAttribute("error", "Vui lòng đăng nhập để thanh toán.");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                    return;
                }
                
                HashMap<Integer, Integer> paymentCart = (HashMap<Integer, Integer>) session.getAttribute("cart");
                String bookingDate = (String) session.getAttribute("bookingDate");
                
                if (paymentCart == null || paymentCart.isEmpty()) {
                    request.setAttribute("error", "Giỏ hàng trống. Vui lòng chọn vé trước khi thanh toán.");
                    request.getRequestDispatcher("/views/buy_ticket.jsp").forward(request, response);
                    return;
                }
                
                // Xử lý lưu thông tin đặt vé vào database
                // (Code thực tế sẽ thêm vào đây)
                
                // Xóa giỏ hàng sau khi thanh toán
                session.setAttribute("cart", null);
                session.setAttribute("bookingDate", null);
                
                // Chuyển hướng đến trang xác nhận đặt vé
                request.setAttribute("message", "Thanh toán thành công!");
                request.getRequestDispatcher("/views/my_tickets.jsp").forward(request, response);
                break;
                
            case "LOGOUT":
                session.setAttribute("cart", null);
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/home");
                break;
                
            default:
                response.sendRedirect(request.getContextPath() + "/home");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            response.sendRedirect("home");
            return;
        }
        
        if (action.equals("SEARCH")) {
            // Xử lý tìm kiếm tuyến xe
            String departure = request.getParameter("departure");
            String destination = request.getParameter("destination");
            String dateStr = request.getParameter("date");
            
            // Thực hiện tìm kiếm và hiển thị kết quả
            // (Code thực tế sẽ thêm vào đây)
            
            // Tạo một danh sách kết quả giả định để demo
            List<BusRoute> searchResults = new ArrayList<>();
            searchResults.add(new BusRoute(1, departure, destination, "07:00", "10:00", 150000, "Bus A"));
            searchResults.add(new BusRoute(2, departure, destination, "09:00", "12:00", 180000, "Bus B"));
            searchResults.add(new BusRoute(3, departure, destination, "13:00", "16:00", 170000, "Bus C"));
            
            request.setAttribute("searchResults", searchResults);
            request.setAttribute("searchDate", dateStr);
            request.getRequestDispatcher("/views/view_buses.jsp").forward(request, response);
            return;
        }
        
        doPost(request, response);
    }
}
