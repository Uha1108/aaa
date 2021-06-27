package com.example.BOOKONLINE;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(name = "UserLoginServlet", value = "/user-login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("log-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String ABSOLUTE_PATH = "/Users/apple/Desktop/password1.txt";
        Stream<String> lines = Files.lines(Paths.get(ABSOLUTE_PATH));
        Map<String, String> m = new HashMap<>();
        lines.forEach(line -> {
            String[] name_pwd = line.split(" ");
            m.put(name_pwd[0], name_pwd[1]);
        });
        String email = request.getParameter("email").trim();
        String pwd = request.getParameter("password").trim();

        if (!m.containsKey(email)) {
            response.sendRedirect("log-in-error.html");
        } else {
            if (!m.get(email).equals(pwd)) {
                response.sendRedirect("log-in-error.html");
            } else {
                request.getSession().setAttribute("user", email);
                response.sendRedirect("index");
            }
            return;
        }
    }
}
