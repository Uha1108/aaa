package com.example.BOOKONLINE;

import com.example.BOOKONLINE.Utils.SongUtils;
import com.example.BOOKONLINE.model.Song;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SongServlet", value = "/song")
public class SongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = 0;
        try {
            i = Integer.parseInt(request.getParameter("id"));
            // Hint: what if this id is not found?
            Song song = SongUtils.getSongByID(i);
            request.setAttribute("song", song);
            String name = (String) request.getSession().getAttribute("user");
            if (name == null) {
                request.setAttribute("name", "Guest");
                request.setAttribute("LogName","Log in");
                request.setAttribute("LogLink","log-in.html");
                request.setAttribute("cart", "log-in.html");
            } else {
                request.setAttribute("name", name);
                request.setAttribute("LogName", "Log out");
                request.setAttribute("LogLink", "log-out");
                request.setAttribute("cart", "cartEmpty.jsp");
            }
            request.getRequestDispatcher("song.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Hint: is it better to show a 404 page?
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
