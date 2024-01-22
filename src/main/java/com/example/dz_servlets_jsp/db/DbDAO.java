package com.example.dz_servlets_jsp.db;

import com.example.dz_servlets_jsp.model.Notepad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbDAO implements task2, task3, task4, task5 {
private final String DB_URL = "jdbc:postgresql://localhost:5432/notepaddb";
private final String USERNAME = "postgres";
private final String PASSWORD = "postgres";
private final String DB_DRIVER = "org.postgresql.Driver";
private final Connection connection;

    public DbDAO() {
        try {
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("подключение невозможно");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("драйвер не распокован");
            throw new RuntimeException(e);
        }
    }

                                              //task2
    @Override
    public List<Notepad> all() {//(отображение всего содержимого таблицы с блокнотами) подключение к базе данных, выборка
        try {
            return getNotepadListFromResultSet(
                    connection.createStatement().executeQuery("SELECT * FROM notepad;"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Notepad> getNotepadListFromResultSet(ResultSet result) throws SQLException {//получение списка блокнотов из результсета
        List<Notepad> all = new ArrayList<>();
        while (result.next()) {
            all.add(new Notepad(result));
        }
        return all;
    }

    @Override
    public List<String> countries() throws SQLException {//(отображение всех стран производителей таблицы) подключение к базе данных, выборка
        String query = "SELECT DISTINCT country FROM notepad;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringListFromResultSet(result, "country");
    }

    @Override
    public Map<String, Integer> countriesSummary() throws SQLException {//(отображение страны и количества блокнотов из данной страны) подключение к базе данных, выборка
        String query = "SELECT DISTINCT country, COUNT(country) FROM notepad\n" +
                "GROUP BY country;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getMapFromResultSet(result, "country");
    }
    private Map<String, Integer> getMapFromResultSet(ResultSet result, String column) throws SQLException {//получение мапы из результсета
        Map<String, Integer> map = new HashMap<>();
        while (result.next()) {
            map.put(result.getString(column), result.getInt(2));
        }
        return map;
    }

    @Override
    public Map<String, Integer> firmasSummary() throws SQLException {//(отображение фирмы и количества блокнотов данной фирмы) подключение к базе данных, выборка
        String query = "SELECT DISTINCT firma, COUNT(firma) FROM notepad\n" +
                "GROUP BY firma;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getMapFromResultSet(result, "firma");
    }

                                                  //task3

    @Override
    public String maxCountNotepadCountry() throws SQLException {//(отображение страны с максимальным количеством блокнотов представленных в таблице) подключение к базе данных, выборка
        String query = "SELECT DISTINCT country, COUNT(country) AS count_data FROM notepad\n" +
                "GROUP BY country\n" +
                "ORDER BY count_data DESC;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringFromResultSet(result, "country");
    }

    private String getStringFromResultSet(ResultSet result, String column) throws SQLException {//получение строки из результсета
        result.next();
        return result.getString(column) + " " + result.getInt(2);
    }

    @Override
    public String minCountNotepadCountry() throws SQLException {//(отображение страны с минимальным количеством блокнотов представленных в таблице) подключение к базе данных, выборка
        String query = "SELECT DISTINCT country, COUNT(country) AS count_data FROM notepad\n" +
                "GROUP BY country\n" +
                "ORDER BY count_data ASC;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringFromResultSet(result, "country");
    }

    @Override
    public String maxCountNotepadFirma() throws SQLException {//(отображение фирмы с максимальным количеством блокнотов представленных в таблице) подключение к базе данных, выборка
        String query = "SELECT DISTINCT firma, COUNT(firma) AS count_data FROM notepad\n" +
                "GROUP BY firma\n" +
                "ORDER BY count_data DESC;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringFromResultSet(result, "firma");
    }

    @Override
    public String minCountNotepadFirma() throws SQLException {//(отображение фирмы с минимальным количеством блокнотов представленных в таблице) подключение к базе данных, выборка
        String query = "SELECT DISTINCT firma, COUNT(firma) AS count_data FROM notepad\n" +
                "GROUP BY firma\n" +
                "ORDER BY count_data ASC;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringFromResultSet(result, "firma");
    }

    @Override
    public List<Notepad> allHardCoverNotepad() throws SQLException {//(отображение всех блокнотов с жестким типом покрытия) подключение к базе данных, выборка
        String query = "SELECT * FROM notepad\n" +
                "WHERE cover_type = 'hard';";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getNotepadListFromResultSet(result);
    }

    @Override
    public List<Notepad> allSoftCoverNotepad() throws SQLException {//(отображение всех блокнотов с мягким типом покрытия) подключение к базе данных, выборка
        String query = "SELECT * FROM notepad\n" +
                "WHERE cover_type = 'soft';";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getNotepadListFromResultSet(result);
    }

                                                 //task4

    @Override
    public List<Notepad> countryTypeFilter(String country) throws SQLException {//выборка блокнотов с выбранным типом страны
        ResultSet result = connection.createStatement().
                executeQuery(String.format("SELECT * FROM notepad WHERE country = '%s'", country));
        return getNotepadListFromResultSet(result);
    }

    @Override
    public List<String> countryType() throws SQLException {//выборка типов стран
        String query = "SELECT DISTINCT country FROM notepad;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringListFromResultSet(result, "country");
    }

    @Override
    public List<Notepad> pageTypeFilter(String appearance) throws SQLException {//выборка списка блокнотов с выбранным типом страницы
        ResultSet resultSet = connection.createStatement().
                executeQuery(String.format("SELECT * FROM notepad WHERE appearance = '%s'", appearance));

        return getNotepadListFromResultSet(resultSet);
    }

    @Override
    public List<String> pageTypes() throws SQLException {//выборка типов внешнего вида страницы из таблицы
        String query = "SELECT DISTINCT appearance FROM notepad;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringListFromResultSet(result, "appearance");
    }
    private List<String> getStringListFromResultSet(ResultSet result, String column) throws SQLException {//получение списка строк из результсета
        List<String> resultAsString = new ArrayList<>();
        while (result.next()) {
            resultAsString.add(result.getString(column));
        }
        return resultAsString;
    }
    @Override
    public List<Notepad> countPageFilter(String page_count) throws SQLException {
        ResultSet resultSet = connection.createStatement().
                executeQuery(String.format("SELECT * FROM notepad WHERE page_count = '%s'", page_count));

        return getNotepadListFromResultSet(resultSet);
    }

    @Override
    public List<String> countPage() throws SQLException {
        String query = "SELECT DISTINCT page_count FROM notepad;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringListFromResultSet(result, "page_count");
    }

    //task5

    @Override
    public Notepad add(Notepad notepad) {
        try {
            connection.createStatement().executeUpdate(getQueryFromNotepad(notepad));
            return notepad;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getQueryFromNotepad(Notepad notepad) throws SQLException {
         return String.format("INSERT INTO notepad (firma, notepad_name, page_count, cover_type, country, appearance)  VALUES ('%s', '%s', '%d', '%s', '%s', '%s')",
                 notepad.getFirma(), notepad.getNotepadName(), notepad.getPagesCount(), notepad.getCoverType(), notepad.getCountry(), notepad.getAppearance());
    }

    private int getCurrentId() throws SQLException {
        ResultSet result = connection.createStatement().executeQuery("SELECT MAX(notepad_id) FROM notepad;");
        result.next();
        return result.getInt("notepad_id") + 1;
    }

    @Override
    public List<String> coverTypes() throws SQLException {
        String query = "SELECT DISTINCT cover_type FROM notepad;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringListFromResultSet(result, "cover_type");
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
