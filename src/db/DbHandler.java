package db;

import entity.ScienceJournal;
import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DbHandler {

    // Константа, в которой хранится адрес подключения
    private static final String CON_STR = "jdbc:sqlite:C:/Users/AleksashinDO/MyProject/ArticleLibrary/DB/ArticleLibraryDb.db";


    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbHandler();
        }
        return instance;
    }


//        Connection connection = null;
//        try {
//            boolean newDb = false;
    // Загрузка драйвера SQLite JDBC
//            Class.forName("org.sqlite.JDBC");

    // Создание соединения с базой данных
//            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/AleksashinDO/MyProject/ArticleLibrary/DB/ArticleLibraryDb.db");



    // Объект, в котором будет храниться соединение с БД
    private Connection connection = null;

    public DbHandler() throws SQLException {
        // Регистрируем драйвер Sqlite
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public void initSQL() {
        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(createTableScienceJournal());
            statement.executeUpdate(createTableMethodAnalysis());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Добавление продукта в БД
    public void addScienceJournal(String journal_name) {
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO science_journal(journal_name, create_ts) " +
                        "VALUES(?), '"+ new Date() +"'")) {
            statement.setObject(1, journal_name);


            // Выполняем запрос
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

    public String createTableScienceJournal(){
        return "CREATE TABLE science_journal ( id INTEGER PRIMARY KEY,create_ts DATE, journal_name VARCHAR(255) NOT NULL)";
    }

    public String createTableMethodAnalysis(){
        return "CREATE TABLE method_analysis ( id INTEGER PRIMARY KEY,create_ts DATE, method_analysisFrame VARCHAR(255) NOT NULL)";
    }
}