package com.example.dz_servlets_jsp.servlets.task2;

import com.example.dz_servlets_jsp.db.DbDAO;
import com.example.dz_servlets_jsp.db.task2;
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

@WebServlet("/all")
public class All extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        completeRequest(request);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/templates/task2/all.jsp");
        dispatcher.forward(request, response);
    }

    private void completeRequest(HttpServletRequest request) {
        task2 dao = new DbDAO();
        List<Notepad> all = dao.all();
        try {
            dao.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("headers", Arrays.stream(Notepad.class.getDeclaredFields()).map(Field::getName).toList());
        request.setAttribute("all", all);
    }

    public void destroy() {
    }
}