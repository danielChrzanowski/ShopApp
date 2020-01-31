package view;

import java.awt.Toolkit;
import handling.Email;
import handling.DBConnection;
import handling.Encryption;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

public class AddEmployee extends javax.swing.JFrame {

    public AddEmployee() {
        initComponents();
    }

    LoginClass lc;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginText = new java.awt.Label();
        hasloText = new java.awt.Label();
        imieText = new java.awt.Label();
        nazwiskoText = new java.awt.Label();
        rejestracjaText = new java.awt.Label();
        loginField = new javax.swing.JTextField();
        nazwiskoField = new javax.swing.JTextField();
        imieField = new javax.swing.JTextField();
        hasloField = new javax.swing.JPasswordField();
        zarejestruj = new javax.swing.JButton();
        cofnij = new javax.swing.JButton();
        powtorzHasloField = new javax.swing.JPasswordField();
        powtorzHaslo = new java.awt.Label();
        emailField = new javax.swing.JTextField();
        emailText = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Magazyn - dodaj pracownika");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/logo.png")));
        setResizable(false);

        loginText.setText("login:");

        hasloText.setText("hasło:");

        imieText.setText("imię:");

        nazwiskoText.setText("nazwisko:");

        rejestracjaText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rejestracjaText.setText("Rejestracja");

        loginField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginFieldKeyPressed(evt);
            }
        });

        nazwiskoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nazwiskoFieldKeyPressed(evt);
            }
        });

        imieField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                imieFieldKeyPressed(evt);
            }
        });

        hasloField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hasloFieldKeyPressed(evt);
            }
        });

        zarejestruj.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        zarejestruj.setText("zarejestruj");
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

        powtorzHasloField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                powtorzHasloFieldKeyPressed(evt);
            }
        });

        powtorzHaslo.setText("powtórz hasło:");

        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailFieldKeyPressed(evt);
            }
        });

        emailText.setText("e-mail:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rejestracjaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cofnij)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zarejestruj))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imieText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hasloText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(powtorzHaslo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(imieField)
                                        .addComponent(loginField)
                                        .addComponent(hasloField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nazwiskoField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(powtorzHasloField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rejestracjaText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(loginText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hasloText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(hasloField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(powtorzHaslo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(powtorzHasloField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imieText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imieField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nazwiskoField)
                    .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailField)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zarejestruj)
                    .addComponent(cofnij))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("Magazyn - dodaj pracownika");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            hasloField.requestFocusInWindow();
        }
    }//GEN-LAST:event_loginFieldKeyPressed

    private void hasloFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hasloFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            powtorzHasloField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            loginField.requestFocusInWindow();
        }
    }//GEN-LAST:event_hasloFieldKeyPressed

    private void powtorzHasloFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_powtorzHasloFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            imieField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            hasloField.requestFocusInWindow();
        }
    }//GEN-LAST:event_powtorzHasloFieldKeyPressed

    private void imieFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imieFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            nazwiskoField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            powtorzHasloField.requestFocusInWindow();
        }
    }//GEN-LAST:event_imieFieldKeyPressed

    private void nazwiskoFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nazwiskoFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            emailField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            imieField.requestFocusInWindow();
        }
    }//GEN-LAST:event_nazwiskoFieldKeyPressed

    private void zarejestrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zarejestrujActionPerformed
        //get all:
        String login = loginField.getText();
        char[] getPassword = hasloField.getPassword();
        String password = new String(getPassword);

        char[] getSecondPassword = powtorzHasloField.getPassword();
        String secondPassword = new String(getSecondPassword);

        String name = imieField.getText();
        String surname = nazwiskoField.getText();
        String email = emailField.getText();

        //check data
        boolean corectness = checkData(login, password, secondPassword, name, surname, email);

        //add to database:
        boolean added = false;
        System.out.println("PRZED: " + login + " " + password);
        if (corectness) {
            added = addToDatabase(login, password, name, surname, email);
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

        if (keyCode == KeyEvent.VK_UP) {
            nazwiskoField.requestFocusInWindow();
        }
    }//GEN-LAST:event_emailFieldKeyPressed

    boolean addToDatabase(String login, String password, String name, String surname, String email) {
        Random random = new Random();
        int activationCode = random.nextInt(9000) + 1000;
        login = Encryption.encrypt(login);
        password = Encryption.encrypt(password);

        System.out.println("ZASZYFROWANE: " + login + " " + password);

        try {
            Connection connection = DBConnection.getDBConnection();
            Statement statement = connection.createStatement();
            ResultSet result;

            //CHECK IF LOGIN AND EMAIL ARE FREE
            result = statement.executeQuery("select login from pracownicy where login like '" + login + "';");
            while (result.next()) {
                String compareLogin = result.getString("login");
                System.out.println("login: " + compareLogin);

                if (compareLogin.equals(login)) {
                    JOptionPane.showMessageDialog(null, "Istnieje już użytkownik z takim loginem!", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            }

            result = statement.executeQuery("select email from pracownicy where email like '" + email + "';");

            while (result.next()) {
                String compareEmail = result.getString("email");
                System.out.println("email: " + compareEmail);
                if (compareEmail.equals(email)) {
                    JOptionPane.showMessageDialog(null, "Istnieje już użytkownik o takim adresie e-mail!", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            }

            //ADD TO DATABASE
            statement.executeUpdate("insert into pracownicy(login, hasło, imię, nazwisko, email, kodAktywacyjny)"
                    + "values('" + login + "', '" + password + "', '" + name + "', '" + surname + "', '" + email + "', '" + activationCode + "')");

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Błąd przy dodawaniu do bazy", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Email.sendEmail(email, "Aktywacja konta MAGAZYN ", "<h3>Aktywacja konta</h3><br>Tw&#243;j kod aktywacyjny to: " + activationCode + "<br>Aktywuj konto w aplikacji zanim si&#281; zalogujesz!", "Wysłano wiadomość na adres: " + email);
        return true;
    }

    boolean checkData(String login, String password, String secondPassword, String name, String surname, String email) {
        boolean poprawnosc = true;
        String[] tab = new String[5];
        tab[0] = login;
        tab[1] = password;
        tab[2] = name;
        tab[3] = surname;
        tab[4] = email;

        String[] komunikat = new String[5];

        //check length
        komunikat[0] = "Login jest za długi!\nMax 10 znaków";
        komunikat[1] = "Hasło jest za długie!\nMax 20 znaków";
        komunikat[2] = "Imię jest za długie!\nMax 20 znaków";
        komunikat[3] = "Nazwisko jest za długie!\nMax 20 znaków";
        komunikat[4] = "E-mail jest za długi!\nMax 30 znaków";

        if (tab[0].length() > 10) {
            JOptionPane.showMessageDialog(null, komunikat[0], "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        for (int i = 1; i < 4; i++) {
            if (tab[i].length() > 20) {
                JOptionPane.showMessageDialog(null, komunikat[i], "Błąd", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (tab[4].length() > 30) {
            JOptionPane.showMessageDialog(null, komunikat[4], "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //check if not empty
        komunikat[0] = "Login nie może byc pusty!";
        komunikat[1] = "Hasło nie może być puste!";
        komunikat[2] = "Imię nie może byc puste!";
        komunikat[3] = "Nazwisko nie może być puste!";
        komunikat[4] = "E-mail nie może być pusty!";

        for (int i = 0; i < 5; i++) {
            if (tab[i].length() <= 0) {
                JOptionPane.showMessageDialog(null, komunikat[i], "Błąd", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        //check repeated password
        if (password.equals(secondPassword) == false) {
            JOptionPane.showMessageDialog(null, "Hasła nie są identyczne", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //check email
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();

        } catch (AddressException ex) {
            JOptionPane.showMessageDialog(null, "Sprawdź poprawność adresu e-mail!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return poprawnosc;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cofnij;
    private javax.swing.JTextField emailField;
    private java.awt.Label emailText;
    private javax.swing.JPasswordField hasloField;
    private java.awt.Label hasloText;
    private javax.swing.JTextField imieField;
    private java.awt.Label imieText;
    private javax.swing.JTextField loginField;
    private java.awt.Label loginText;
    private javax.swing.JTextField nazwiskoField;
    private java.awt.Label nazwiskoText;
    private java.awt.Label powtorzHaslo;
    private javax.swing.JPasswordField powtorzHasloField;
    private java.awt.Label rejestracjaText;
    private javax.swing.JButton zarejestruj;
    // End of variables declaration//GEN-END:variables
}
