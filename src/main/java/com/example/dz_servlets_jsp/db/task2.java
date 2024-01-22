package com.example.dz_servlets_jsp.db;

import com.example.dz_servlets_jsp.model.Notepad;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface task2 {
    List<Notepad> all();
    List<String> countries() throws SQLException;
    Map<String, Integer> countriesSummary() throws SQLException;

    Map<String, Integer> firmasSummary() throws SQLException;
    void closeConnection() throws SQLException;
}
