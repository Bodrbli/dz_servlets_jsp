package com.example.dz_servlets_jsp.db;

import com.example.dz_servlets_jsp.model.Notepad;

import java.sql.SQLException;
import java.util.List;

public interface task4 {
    List<Notepad> pageTypeFilter(String type) throws SQLException;
    List<String> pageTypes() throws SQLException;
    List<Notepad> countryTypeFilter(String country) throws SQLException;
    List<String> countryType() throws SQLException;
    List<Notepad> countPageFilter(String page_count) throws SQLException;
    List<String> countPage() throws SQLException;
    void closeConnection() throws SQLException;
}
