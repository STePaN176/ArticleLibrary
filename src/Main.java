import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class Main {
    static HashMap<String, String> codeName = new HashMap<>();
    static HashMap<String, String> codeKeyWords = new HashMap<>();
    public static MenuFrame app = new MenuFrame();

    public static void main(String[] args) throws IOException {
        app.setBounds(400, 400, 650, 215);
        app.setVisible(true);
        System.out.println("Запущено");

        Connection connection = null;
//        try {
//            // Загрузка драйвера SQLite JDBC
//            Class.forName("org.sqlite.JDBC");
//
//            // Создание соединения с базой данных
//            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/AleksashinDO/MyProject/ArticleLibrary/DB/ArticleLibraryDb.db");
//            System.out.println("Соединение с базой данных успешно установлено");
//            String query = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT NOT NULL, age INTEGER)";
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(query);
//            System.out.println("Таблица создана успешно");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Не удалось найти драйвер SQLite JDBC");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("Не удалось установить соединение с базой данных");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Ошибка при закрытии соединения с базой данных");
//                e.printStackTrace();
//            }
//        }
    }
}
