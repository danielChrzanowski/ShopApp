package view;

import java.awt.Toolkit;
import handling.Email;
import handling.DBConnection;
import handling.Encryption;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

public class RecoverPassword extends javax.swing.JFrame {

    public RecoverPassword() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        odzyskajHasloText = new java.awt.Label();
        zarejestruj = new javax.swing.JButton();
        cofnij = new javax.swing.JButton();
        emailField = new javax.swing.JTextField();
        emailText = new java.awt.Label();
        information = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Magazyn - odzyskaj hasło");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/logo.png")));
        setResizable(false);

        odzyskajHasloText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        odzyskajHasloText.setText("Odzyskaj hasło");

        zarejestruj.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        zarejestruj.setText("zatwierdź");
        zarejestruj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zarejestrujActionPerformed(evt);
            }
        });
        zarejestruj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                zarejestrujKeyPressed(evt);
            }
        });

        cofnij.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        cofnij.setText("cofnij");
        cofnij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cofnijActionPerformed(evt);
            }
        });
        cofnij.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cofnijKeyPressed(evt);
            }
        });

        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailFieldKeyPressed(evt);
            }
        });

        emailText.setText("e-mail:");

        information.setAlignment(java.awt.Label.CENTER);
        information.setText("(Na podany adres e-mail zostanie wysłane tymczasowe hasło)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(odzyskajHasloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cofnij)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zarejestruj))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(emailField))
                            .addComponent(information, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(odzyskajHasloText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailField)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(information, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zarejestruj)
                    .addComponent(cofnij))
                .addContainerGap())
        );

        odzyskajHasloText.getAccessibleContext().setAccessibleName("Odzyskaj Hasło");

        getAccessibleContext().setAccessibleDescription("Magazyn - odzyskaj hasło");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void zarejestrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zarejestrujActionPerformed
        String email = emailField.getText();

        //sprawdz poprawność:
        boolean correctness = checkDataCorrectness(email);

        //dodajDoBazy:
        boolean added = false;
        if (correctness) {
            added = sendNewPassword(email);
        }

        if (added) {
            this.dispose();
        }
    }//GEN-LAST:event_zarejestrujActionPerformed

    private void cofnijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cofnijActionPerformed
        this.dispose();
    }//GEN-LAST:event_cofnijActionPerformed

    private void zarejestrujKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zarejestrujKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            zarejestruj.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            emailField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            cofnij.requestFocusInWindow();
        }
    }//GEN-LAST:event_zarejestrujKeyPressed

    private void cofnijKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cofnijKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            cofnij.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            emailField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            zarejestruj.requestFocusInWindow();
        }
    }//GEN-LAST:event_cofnijKeyPressed

    private void emailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            zarejestruj.doClick();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            zarejestruj.requestFocusInWindow();
        }

    }//GEN-LAST:event_emailFieldKeyPressed

    boolean sendNewPassword(String email) {
        String login, password;

        try {
            Connection connection = DBConnection.getDBConnection();
            Statement statement = connection.createStatement();
            ResultSet result;

            //SPRAWDZ CZY JEST JUZ TAKI PRACOWNIK
            result = statement.executeQuery("select email, login, id from pracownicy where email like '" + email + "';");
            result.next();
            String compareEmail = result.getString("email");
            login = result.getString("login");
            String id = result.getString("id");

            login = Encryption.decrypt(login);
            System.out.println(compareEmail + " " + login + " " + id);

            Random random = new Random();
            int kod = random.nextInt(9000) + 1000;
            String newPassword = Integer.toString(kod);
            password = newPassword;
            newPassword = Encryption.encrypt(newPassword);

            //DODAJ DO BAZY
            statement.executeUpdate("update pracownicy set hasło='" + newPassword + "' where id='" + id + "';");

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Nie istnieje użytkownik o takim adresie e-mail!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Email.sendEmail(email, "Odzyskaj hasło konta MAGAZYN ", "<h3>Odzyskiwanie has&#322;a</h3><br>Tw&#243;j login to: " + login + "<br>Tymczasowe has&#322;o: " + password, "Wysłano wiadomość na adres: " + email);
        return true;
    }

    boolean checkDataCorrectness(String email) {
        boolean correctness;

        //CHECK LENGTH:
        if (email.length() <= 30) {
            correctness = true;
        } else {
            JOptionPane.showMessageDialog(null, "E-mail jest za długi!\nMax 30 znaków", "Błąd", JOptionPane.ERROR_MESSAGE);
            correctness = false;
        }

        if (correctness == true) {
            if (email.length() > 0) {
                correctness = true;
            } else {
                JOptionPane.showMessageDialog(null, "E-mail nie może być pusty!", "Błąd", JOptionPane.ERROR_MESSAGE);
                correctness = false;
            }
        }

        //CHECK EMAIL:
        if (correctness) {
            try {
                InternetAddress emailAddr = new InternetAddress(email);
                emailAddr.validate();
                
            } catch (AddressException ex) {
                JOptionPane.showMessageDialog(null, "Sprawdź poprawność adresu e-mail!", "Błąd", JOptionPane.ERROR_MESSAGE);
                correctness = false;
            }
            
        }

        return correctness;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cofnij;
    private javax.swing.JTextField emailField;
    private java.awt.Label emailText;
    private java.awt.Label information;
    private java.awt.Label odzyskajHasloText;
    private javax.swing.JButton zarejestruj;
    // End of variables declaration//GEN-END:variables
}
