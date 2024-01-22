package com.example.dz_servlets_jsp.db;

import com.example.dz_servlets_jsp.model.Notepad;

import java.sql.SQLException;
import java.util.List;

public interface task5 {

    Notepad add(Notepad notepad);
    List<String> coverTypes() throws SQLException;
    List<String> pageTypes() throws SQLException;
    void closeConnection() throws SQLException;
}
