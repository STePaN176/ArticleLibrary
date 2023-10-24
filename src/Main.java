import db.DbHandler;

import java.io.IOException;
import java.sql.SQLException;

import static frame.MenuFrame.appFrame;


public class Main {

    public static void main(String[] args) throws IOException {
        appFrame.setVisible(true);

        if (true) {
            initDb();
        }
    }

    protected static void initDb() {
        try {
            DbHandler dbHandler = DbHandler.getInstance();
            dbHandler.initSQL();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
