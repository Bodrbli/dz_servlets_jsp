package com.example.dz_servlets_jsp.servlets.task3;

import com.example.dz_servlets_jsp.db.DbDAO;
import com.example.dz_servlets_jsp.db.task3;
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

@WebServlet("/allHardCoverNotepad")
public class AllHardCoverNotepad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            completeRequest(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/templates/task3/allHardCoverNotepad.jsp");
        dispatcher.forward(request, response);
    }

    private void completeRequest(HttpServletRequest request) throws SQLException {
        task3 dao = new DbDAO();
        List<Notepad> allHardCoverNotepad = dao.allHardCoverNotepad();
        request.setAttribute("allHardCoverNotepad", allHardCoverNotepad);
        request.setAttribute("headers", Arrays.stream(Notepad.class.getDeclaredFields()).map(Field::getName).toList());
        try {
            dao.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
