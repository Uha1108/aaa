package com.example.BOOKONLINE;

import com.example.BOOKONLINE.Utils.CONSTANT;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;

@WebServlet(name = "UserSignupServlet", value = "/user-signup")
public class UserSignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-up.html").forward(request, response);
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
        if (!(email == null) && !(pwd == null)) {
            List<String> data1 = Arrays.asList(email, pwd);
            String newuser = System.lineSeparator() + String.join(" ", data1);
            Files.write(Paths.get("/Users/apple/Desktop/password1.txt"),
                    newuser.getBytes(), APPEND);
            response.sendRedirect("sign-up-success.html");

        } else {
            response.sendRedirect("sign-up-error.html");
        }
        return;
    }
}
