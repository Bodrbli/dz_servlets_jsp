package com.example.dz_servlets_jsp.servlets.task4;

import com.example.dz_servlets_jsp.db.DbDAO;
import com.example.dz_servlets_jsp.db.task4;
import com.example.dz_servlets_jsp.model.Notepad;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/countPageFilter")
public class CountPageFilter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println(request.getParameter("page_count"));
        try {
            completeRequest(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher =
                request.getServletContext().getRequestDispatcher("/templates/task4/countPageFilter.jsp");
        dispatcher.forward(request, response);
    }

    private void completeRequest(HttpServletRequest request) throws SQLException {
        task4 dao = new DbDAO();
        List<String> page_count = dao.countPage();
        request.setAttribute("page_count", page_count);
        if (request.getParameter("page_count") != null) {
            request.setAttribute("filtered", dao.countPageFilter(request.getParameter("page_count")));
            request.setAttribute("headers",
                    Arrays.stream(Notepad.class.getDeclaredFields()).map(Field::getName).toList());
        }
        dao.closeConnection();
    }
}
