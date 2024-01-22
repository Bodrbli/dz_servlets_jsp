package com.example.dz_servlets_jsp.servlets.task3;

import com.example.dz_servlets_jsp.db.DbDAO;
import com.example.dz_servlets_jsp.db.task3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/minCountNotepadFirma")
public class MinCountNotepadFirma extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            completeRequest(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/templates/task3/minCountNotepadFirma.jsp");
        dispatcher.forward(request, response);
    }

    private void completeRequest(HttpServletRequest request) throws SQLException {
        task3 dao = new DbDAO();
        String minCountNotepadFirma = dao.minCountNotepadFirma();
        request.setAttribute("minCountNotepadFirma", minCountNotepadFirma);
        try {
            dao.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
