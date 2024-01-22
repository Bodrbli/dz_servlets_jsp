package com.example.dz_servlets_jsp.model;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Notepad {
    private Integer id;
    private String firma;
    private String notepadName;
    private  int pagesCount;
    private String coverType;
    private String country;
    private String appearance;

    public Notepad(String brand, String model, int pagesAmount, String cover, String country, String type) {
        this.id = null;
        this.firma = brand;
        this.notepadName = model;
        this.pagesCount = pagesAmount;
        this.coverType = cover;
        this.country = country;
        this.appearance = type;
    }

    public Notepad(ResultSet result) throws SQLException {
        this.id = result.getInt("notepad_id");
        this.firma = result.getString("firma");
        this.notepadName = result.getString("notepad_name");
        this.pagesCount = result.getInt("page_count");
        this.coverType = result.getString("cover_type");
        this.country = result.getString("country");
        this.appearance = result.getString("appearance");
    }

    public Notepad(HttpServletRequest request) {

        this.firma = request.getParameter("firma");
        this.notepadName = request.getParameter("notepadName");
        this.pagesCount = Integer.parseInt(request.getParameter("pageCount"));
        this.coverType = request.getParameter("cover");
        this.country = request.getParameter("country");
        this.appearance = request.getParameter("appearance");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getNotepadName() {
        return notepadName;
    }

    public void setNotepadName(String notepadName) {
        this.notepadName = notepadName;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    @Override
    public String toString() {
        return "Notepad{" +
                "id=" + id +
                ", firma='" + firma + '\'' +
                ", notepadName='" + notepadName + '\'' +
                ", pagesCount=" + pagesCount +
                ", coverType='" + coverType + '\'' +
                ", country='" + country + '\'' +
                ", appearane='" + appearance + '\'' +
                '}';
    }
}
