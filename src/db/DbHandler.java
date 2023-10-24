package db;

import conf.AppConfig;
import entity.MethodAnalysis;
import entity.ScienceJournal;
import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DbHandler {

    private static final String ADRESS_DB = AppConfig.getAdressDb();


    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbHandler();
        }
        return instance;
    }

    private Connection connection = null;

    public DbHandler() throws SQLException {
        // Регистрируем драйвер Sqlite
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(ADRESS_DB);
    }

    public void initSQL() {
        try (Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(createTableScienceJournal());
            statement.executeUpdate(createEmptyScienceJournal());
            statement.executeUpdate(createTableMethodAnalysis());
            statement.executeUpdate(createEmptyMethodAnalys());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addScienceJournal(String journal_name) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO science_journal(journal_name, create_ts) VALUES(?,?)")) {
            statement.setObject(1, journal_name);
            statement.setObject(2, (new java.sql.Date(new Date().getTime()).toString()));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMethodAnalysis(String method_analysis_name) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO method_analysis(method_analysis_name, create_ts) VALUES(?,?)")) {
            statement.setObject(1, method_analysis_name);
            statement.setObject(2, (new java.sql.Date(new Date().getTime()).toString()));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Удаление продукта по id
    public void deleteProduct(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM science_journal WHERE id = ?")) {
            statement.setObject(1, id);
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String createTableScienceJournal() {
        return "CREATE TABLE science_journal ( id INTEGER PRIMARY KEY,create_ts DATE, journal_name VARCHAR(255) NOT NULL)";
    }

    public String createTableMethodAnalysis() {
        return "CREATE TABLE method_analysis ( id INTEGER PRIMARY KEY,create_ts DATE, method_analysis_name VARCHAR(255) NOT NULL)";
    }

    public String createEmptyScienceJournal() {
        return "INSERT INTO science_journal (journal_name) VALUES(' ')";
    }

    public String createEmptyMethodAnalys() {
        return "INSERT INTO method_analysis (method_analysis_name) VALUES(' ')";
    }

    public List<ScienceJournal> getAllJournals() {
        try (Statement statement = this.connection.createStatement()) {
            List<ScienceJournal> journals = new ArrayList<ScienceJournal>();
            ResultSet resultSet = statement.executeQuery("SELECT id, journal_name FROM science_journal");
            while (resultSet.next()) {
                journals.add(new ScienceJournal(resultSet.getInt("id"),
                        resultSet.getString("journal_name")));
            }
            return journals;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<MethodAnalysis> getAllMethodAnalysis() {
        try (Statement statement = this.connection.createStatement()) {
            List<MethodAnalysis> journals = new ArrayList<MethodAnalysis>();
            ResultSet resultSet = statement.executeQuery("SELECT id, method_analysis_name FROM method_analysis");
            while (resultSet.next()) {
                journals.add(new MethodAnalysis(resultSet.getInt("id"),
                        resultSet.getString("method_analysis_name")));
            }
            return journals;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}