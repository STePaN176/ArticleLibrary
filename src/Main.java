import org.sqlite.SQLiteException;

import javax.management.OperationsException;
import java.awt.Frame;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class Main {
    static HashMap<String, String> codeName = new HashMap<>();
    static HashMap<String, String> codeKeyWords = new HashMap<>();
    public static Frame appFrame = new MenuFrame();

    public static void main(String[] args) throws IOException {
        appFrame.setBounds(400, 400, 650, 215);
        appFrame.setVisible(true);
        System.out.println("Запущено");

        Connection connection = null;
        try {
            boolean newDb = false;
            // Загрузка драйвера SQLite JDBC
            Class.forName("org.sqlite.JDBC");

            // Создание соединения с базой данных
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/AleksashinDO/MyProject/ArticleLibrary/DB/ArticleLibraryDb.db");
            System.out.println("Соединение с базой данных успешно установлено");
            String query = "";
            Statement statement = connection.createStatement();
            if (true) {
                query = "CREATE TABLE science_journal ( id INTEGER PRIMARY KEY,create_ts DATE, name VARCHAR(255) NOT NULL)";
                try {
                    statement.executeUpdate(query);
                    System.out.printf("ещё нет");
                } catch (SQLiteException e){
                    System.out.printf("уже есть");
                }
            }

            System.out.println("Таблица создана успешно");
            query = "INSERT INTO science_journal (id, create_ts, name)\n" +
                    "VALUES \n" +
                    "  (1, '2021-01-01', 'John'),\n" +
                    "  (2, '2021-01-02', 'Jane'),\n" +
                    "  (3, '2021-01-03', 'Mike')";
            statement.executeUpdate(query);
            System.out.println("Таблица успешно заполнена");
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось найти драйвер SQLite JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Не удалось установить соединение с базой данных");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Ошибка при закрытии соединения с базой данных");
                e.printStackTrace();
            }
        }
    }
}
