package handling;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Email {

    private Email() {
    }

    public static void sendEmail(String addressee, String title, String message, String statement) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        String loginEmail = null, passwordEmail = null;

        try {
            URL url = ClassLoader.getSystemResource("data/config.properties");
            Properties prop = new Properties();
            prop.load(url.openStream());

            loginEmail = prop.getProperty("loginEmail");
            passwordEmail = prop.getProperty("passwordEmail");

            loginEmail = Encryption.decrypt(loginEmail);
            passwordEmail = Encryption.decrypt(passwordEmail);

        } catch (IOException ex) {
            System.out.println("Błąd przy czytaniu z pliku config");
        }

        final String login = loginEmail, password = passwordEmail;
        Session session;
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(login, password);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            InternetAddress[] address = InternetAddress.parse(addressee, true);

            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("(hh:mm:ss, dd.mm.yyyy)").format(new Date());

            msg.setSubject(title + timeStamp, "UTF-8");
            msg.setSentDate(new Date());
            msg.setContent(message, "text/html");
            msg.setHeader("Content-Type", "text/html; charset=UTF-8");

            Transport.send(msg);
            JOptionPane.showMessageDialog(null, statement, "Sprawdź e-mail!", JOptionPane.DEFAULT_OPTION);

        } catch (MessagingException mex) {
            System.out.println("Błąd przy wysyłaniu e-maila");
        }
        
    }

}
