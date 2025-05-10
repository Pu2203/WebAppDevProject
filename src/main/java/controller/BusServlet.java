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

@WebServlet(name = "BusServlet", urlPatterns = {"/BusServlet"})

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
            
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
