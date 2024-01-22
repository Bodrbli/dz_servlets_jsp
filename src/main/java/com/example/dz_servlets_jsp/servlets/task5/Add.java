package com.example.dz_servlets_jsp.servlets.task5;

import com.example.dz_servlets_jsp.db.DbDAO;
import com.example.dz_servlets_jsp.db.task5;
import com.example.dz_servlets_jsp.model.Notepad;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add")
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            completeRequest(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher =
                request.getServletContext().getRequestDispatcher("/templates/task5/add.jsp");
        dispatcher.forward(request, response);
    }

    private void completeRequest(HttpServletRequest request) throws SQLException {
        task5 dao = new DbDAO();
        request.setAttribute("appearances", dao.pageTypes());
        request.setAttribute("coverTypes", dao.coverTypes());
        dao.closeConnection();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        task5 dao = new DbDAO();
        Notepad notepadToAdd = new Notepad(request);
        dao.add(notepadToAdd);
        request.setAttribute("notepadAdded", notepadToAdd);
        try {
            dao.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
