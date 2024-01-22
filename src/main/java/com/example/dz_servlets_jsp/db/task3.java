package com.example.dz_servlets_jsp.db;

import com.example.dz_servlets_jsp.model.Notepad;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface task3 {
    String maxCountNotepadCountry() throws SQLException;
    String minCountNotepadCountry() throws SQLException;
    String maxCountNotepadFirma() throws SQLException;
    String minCountNotepadFirma() throws SQLException;
    List<Notepad> allHardCoverNotepad() throws SQLException;
    List<Notepad> allSoftCoverNotepad() throws SQLException;
    void closeConnection() throws SQLException;
}
