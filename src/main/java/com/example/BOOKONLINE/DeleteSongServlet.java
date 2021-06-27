package com.example.BOOKONLINE;

import com.example.BOOKONLINE.Utils.SongUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(name = "DeleteSongServlet", value = "/delete-song")
public class DeleteSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String log = (String) session.getAttribute("admin");
        if (log != null && log.equals("log")) {
            request.getRequestDispatcher("delete-song.html").forward(request, response);
        } else {
            response.sendRedirect("admin-login.html");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int songID = Integer.parseInt(request.getParameter("id").trim());
        SongUtils.deleteSong(songID);

    }
}
