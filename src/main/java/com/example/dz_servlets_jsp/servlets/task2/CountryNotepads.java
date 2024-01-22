package com.example.dz_servlets_jsp.servlets.task2;

import com.example.dz_servlets_jsp.db.DbDAO;
import com.example.dz_servlets_jsp.db.task2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/countryNotepads")
public class CountryNotepads extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            completeRequest(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/templates/task2/countryNotepads.jsp");
        dispatcher.forward(request, response);
    }

    private void completeRequest(HttpServletRequest request) throws SQLException {
        task2 dao = new DbDAO();
        Map<String, Integer> countryNotepads = dao.countriesSummary();
        request.setAttribute("countryNotepads", countryNotepads);
        try {
            dao.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
