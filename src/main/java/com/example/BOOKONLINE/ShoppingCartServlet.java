package com.example.BOOKONLINE;

import com.example.BOOKONLINE.Utils.SongUtils;
import com.example.BOOKONLINE.model.Song;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = "/shopping-cart")

public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getSession().getAttribute("user");
        if (name != null) {
            String refer = request.getHeader("referer");
            int num = Integer.parseInt(refer.substring(refer.lastIndexOf("/") + 9));
            List<Song> songs = SongUtils.loadSongs();
            List<Song> results = songs.stream().filter(s -> s.getId() == (num)).collect(Collectors.toList());
            request.setAttribute("song", results);
            response.sendRedirect("shoppingCart.jsp");
        } else {
            request.getRequestDispatcher("log-in.html").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
