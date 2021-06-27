package com.example.BOOKONLINE;

import com.example.BOOKONLINE.Utils.AccountUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/admin-login")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("admin-login.html") .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email").trim();
        String pwd = request.getParameter("password").trim();

        if (AccountUtils.checkLogin(email, pwd)) {
            // both email and pwd are correct.
            request.getSession().setAttribute("admin", "log");
            response.sendRedirect("admin");
        } else {
            response.sendRedirect("admin-error.html");
        }
        return;
    }
}