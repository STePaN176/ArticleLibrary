import db.DbHandler;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static Frame appFrame = new MenuFrame();

    public static void main(String[] args) throws IOException {
        appFrame.setBounds(400, 400, 650, 215);
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
