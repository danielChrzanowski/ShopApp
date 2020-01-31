package handling;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class DBConnection{

    static Connection CONNECTION = null;

    private DBConnection() {
    }

    //CLOUD DATABASE CONNECTION
    public static Connection getDBConnection() {
        try {
            if (CONNECTION == null) {
                //get data from config file:
                String login = null, password = null, databaseData = null;

                try {
                    URL url = ClassLoader.getSystemResource("data/config.properties");
                    Properties prop = new Properties();
                    prop.load(url.openStream());

                    login = prop.getProperty("loginDB");
                    password = prop.getProperty("passwordDB");
                    databaseData = prop.getProperty("dataDB");

                } catch (IOException ex) {
                    System.out.println("Błąd przy czytaniu z pliku config");
                }

                //decryption:
                login = Encryption.decrypt(login);
                password = Encryption.decrypt(password);
                databaseData = Encryption.decrypt(databaseData);

                //connect:
                CONNECTION = DriverManager.getConnection("jdbc:mysql://" + databaseData + "?useTimezone=true&serverTimezone=UTC", login, password);
                System.out.println("Połączono z bazą danych w chmurze");
            }

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Błąd przy łączeniu z bazą danych w chmurze;\nSprawdź połączenie z internetem!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }

        return CONNECTION;
    }

    //LOCAL DATABASE CONNECTION
//    public static Connection getDBConnection() {
//        try {
//            if (CONNECTION == null) {
//                CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useTimezone=true&serverTimezone=UTC", "root", "qwerty");
//                System.out.println("Połączono z lokalną bazą danych");
//            }
//
//        } catch (SQLException exc) {
//            JOptionPane.showMessageDialog(null, "Błąd przy łączeniu z lokalną bazą danych;\nSprawdź połączenie z lokalną bazą danych!", "Błąd", JOptionPane.ERROR_MESSAGE);
//
//        }
//
//        return CONNECTION;
//    }

}
