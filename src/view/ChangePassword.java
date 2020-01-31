package view;

import java.awt.Toolkit;
import handling.Email;
import handling.DBConnection;
import handling.Encryption;
import handling.Employee;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ChangePassword extends javax.swing.JFrame {

    Connection connection;
    Statement statement;
    ResultSet result;

    Employee pracownik;

    public ChangePassword() {
        initComponents();

        connection = DBConnection.getDBConnection();

        try {
            statement = connection.createStatement();
        } catch (SQLException exc) {
            System.out.println("Błąd przy tworzeniu widoku pracownika!");
        }

        pracownik = Employee.getEmployee();
        stopka.setText("(" + pracownik.name + " " + pracownik.surname + ")");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aktualneHasloText = new java.awt.Label();
        zmienHasloText = new java.awt.Label();
        aktualneHasloField = new javax.swing.JPasswordField();
        zatwierdz = new javax.swing.JButton();
        cofnij = new javax.swing.JButton();
        noweHasloField = new javax.swing.JPasswordField();
        noweHasloText = new java.awt.Label();
        powtorzNoweHasloText = new java.awt.Label();
        powtorzNoweHasloField = new javax.swing.JPasswordField();
        stopka = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Magazyn - zmień hasło");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/logo.png")));
        setResizable(false);

        aktualneHasloText.setText("aktualne hasło:");

        zmienHasloText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        zmienHasloText.setText("Zmień hasło");

        aktualneHasloField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aktualneHasloFieldKeyPressed(evt);
            }
        });

        zatwierdz.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        zatwierdz.setText("zatwierdź");
        zatwierdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zatwierdzActionPerformed(evt);
            }
        });
        zatwierdz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                zatwierdzKeyPressed(evt);
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

        noweHasloField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noweHasloFieldKeyPressed(evt);
            }
        });

        noweHasloText.setText("nowe hasło:");

        powtorzNoweHasloText.setText("powtórz nowe hasło:");

        powtorzNoweHasloField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                powtorzNoweHasloFieldKeyPressed(evt);
            }
        });

        stopka.setAlignment(java.awt.Label.RIGHT);
        stopka.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cofnij)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zatwierdz))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noweHasloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aktualneHasloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aktualneHasloField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noweHasloField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(powtorzNoweHasloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(powtorzNoweHasloField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(zmienHasloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(stopka, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zmienHasloText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aktualneHasloText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(aktualneHasloField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(noweHasloText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noweHasloField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(powtorzNoweHasloText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(powtorzNoweHasloField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zatwierdz)
                    .addComponent(cofnij))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("Magazyn - zmień hasło");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aktualneHasloFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aktualneHasloFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            noweHasloField.requestFocusInWindow();
        }
    }//GEN-LAST:event_aktualneHasloFieldKeyPressed

    private void noweHasloFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noweHasloFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            powtorzNoweHasloField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            aktualneHasloField.requestFocusInWindow();
        }
    }//GEN-LAST:event_noweHasloFieldKeyPressed

    private void zatwierdzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zatwierdzActionPerformed
        //pobierz all:
        char[] wezHaslo = aktualneHasloField.getPassword();
        String aktualneHaslo = new String(wezHaslo);

        char[] wezNoweHaslo = noweHasloField.getPassword();
        String noweHaslo = new String(wezNoweHaslo);

        char[] wezDrugieNoweHaslo = powtorzNoweHasloField.getPassword();
        String drugieNoweHaslo = new String(wezDrugieNoweHaslo);

        //sprawdź poprawność:
        boolean correctness = changeInDataBase(aktualneHaslo, noweHaslo, drugieNoweHaslo);

        if (correctness) {
            Email.sendEmail(pracownik.email, "Zmiana hasła w aplikacji MAGAZYN ", "<h3>Zmiana has&#322;a</h3><br>Has&#322;o u&#380;ytkownika: " + pracownik.name + " " + pracownik.surname + " zosta&#322;o zmienione.", "Pomyślnie zmieniono hasło");
            this.dispose();
        }
    }//GEN-LAST:event_zatwierdzActionPerformed

    private void cofnijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cofnijActionPerformed
        this.dispose();
    }//GEN-LAST:event_cofnijActionPerformed

    private void zatwierdzKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zatwierdzKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            zatwierdz.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            powtorzNoweHasloField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            cofnij.requestFocusInWindow();
        }
    }//GEN-LAST:event_zatwierdzKeyPressed

    private void cofnijKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cofnijKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            cofnij.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            powtorzNoweHasloField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            zatwierdz.requestFocusInWindow();
        }
    }//GEN-LAST:event_cofnijKeyPressed

    private void powtorzNoweHasloFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_powtorzNoweHasloFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            zatwierdz.doClick();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            zatwierdz.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            noweHasloField.requestFocusInWindow();
        }

    }//GEN-LAST:event_powtorzNoweHasloFieldKeyPressed

    boolean changeInDataBase(String actual, String first, String second) {
        boolean correctness = true;

        //CHECK DATA
        if (actual.length() < 1 || first.length() < 1 || second.length() < 1) {
            JOptionPane.showMessageDialog(null, "Musisz wypełnić wszystkie pola!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (first.length() > 20) {
            JOptionPane.showMessageDialog(null, "Nowe hasło jest za długie!\nMax 20 znaków!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (first.equals(second) == false) {
            JOptionPane.showMessageDialog(null, "Powtórzenia nowego hasła nie są takie same!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (actual.equals(pracownik.password) == false) {
            JOptionPane.showMessageDialog(null, "Aktuale hasło nie jest prawidłowe!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            //CHANGE IN DB
            result = statement.executeQuery("select id from pracownicy where login like '" + Encryption.encrypt(pracownik.login) + "';");
            result.next();
            int id = result.getInt("id");

            System.out.println("ID: " + id + "\nHasło: " + second);

            first = Encryption.encrypt(first);
            statement.executeUpdate("update pracownicy set hasło='" + first + "' where id='" + id + "';");

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Błąd przy zmienianiu hasła w bazie", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return correctness;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField aktualneHasloField;
    private java.awt.Label aktualneHasloText;
    private javax.swing.JButton cofnij;
    private javax.swing.JPasswordField noweHasloField;
    private java.awt.Label noweHasloText;
    private javax.swing.JPasswordField powtorzNoweHasloField;
    private java.awt.Label powtorzNoweHasloText;
    private java.awt.Label stopka;
    private javax.swing.JButton zatwierdz;
    private java.awt.Label zmienHasloText;
    // End of variables declaration//GEN-END:variables
}
