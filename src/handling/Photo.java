package handling;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Photo {

    Connection connection;
    Statement statement;
    ResultSet result;

    public Photo() {
        connection = DBConnection.getDBConnection();

        try {
            statement = connection.createStatement();

        } catch (SQLException exc) {
            System.out.println("Błąd przy tworzeniu obiektu klasy Photo!");
        }

    }

    public boolean updatePhoto(int id, File file) {
        if (checkImage(file)) {
            String sql = "update produkty set zdjęcie=? where id='" + id + "';";

            try {
                PreparedStatement myStmt = connection.prepareStatement(sql);
                FileInputStream input = new FileInputStream(file);

                myStmt.setBinaryStream(1, input);
                myStmt.executeUpdate();

            } catch (SQLException | FileNotFoundException ex) {
                System.out.println("Błąd przy dodawaniu zdjęcia");
            }
            return true;

        } else {
            return false;
        }
    }

    public static boolean checkImage(File file) {
        String mimetype = new MimetypesFileTypeMap().getContentType(file);
        String type = mimetype.split("/")[0];

        if (type.equals("image") == false) {
            JOptionPane.showMessageDialog(null, "Wybrany plik nie jest zdjęciem .jpg!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }

        return type.equals("image");
    }

    public BufferedImage getBufferedImage(Object id) {
        BufferedImage photo = null;
        int idInt = (Integer) id;
        if (connection != null) {
            try {
                result = statement.executeQuery("select zdjęcie from produkty where id='" + idInt + "';");
                result.next();

                Blob blob = result.getBlob("zdjęcie");

                if (blob != null) {
                    InputStream is = blob.getBinaryStream(1, blob.length());
                    photo = ImageIO.read(is);

                } else {
                    photo = ImageIO.read(Photo.class.getResource("/data/noPhoto.png"));
                }

            } catch (SQLException ex) {
                System.out.println("Błąd przy konwertowaniu zdjęcia SQL");
                return null;
            } catch (IOException ex) {
                System.out.println("Błąd przy konwertowaniu zdjęcia IO");
                return null;
            }
        }
        return photo;
    }

    public Dimension getScaledDimension(Dimension imageSize, Dimension boundary) {
        double widthRatio = boundary.getWidth() / imageSize.getWidth();
        double heightRatio = boundary.getHeight() / imageSize.getHeight();
        double ratio = Math.min(widthRatio, heightRatio);

        return new Dimension((int) (imageSize.width * ratio),
                (int) (imageSize.height * ratio));
    }

}
