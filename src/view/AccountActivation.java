package view;

import java.awt.Toolkit;
import handling.DBConnection;
import handling.Email;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

public class AccountActivation extends javax.swing.JFrame {

    Connection connection;
    Statement statement;
    ResultSet result;

    public AccountActivation() {
        initComponents();

        connection = DBConnection.getDBConnection();

        try {
            statement = connection.createStatement();

        } catch (SQLException exc) {
            System.out.println("Błąd przy tworzeniu widoku aktywacji konta!");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cofnij = new javax.swing.JButton();
        kodAktywacyjnyText = new java.awt.Label();
        kodAktywacyjnyField = new javax.swing.JTextField();
        emailText = new java.awt.Label();
        emailField = new javax.swing.JTextField();
        aktywuj = new javax.swing.JButton();
        wyslijKodPonownie = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Magazyn - aktywacja konta");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/logo.png")));
        setResizable(false);

        cofnij.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        cofnij.setText("Cofnij");
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

        kodAktywacyjnyText.setText("kod aktywacyjny:");

        kodAktywacyjnyField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodAktywacyjnyFieldKeyPressed(evt);
            }
        });

        emailText.setText("email:");

        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailFieldKeyPressed(evt);
            }
        });

        aktywuj.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        aktywuj.setText("Aktywuj");
        aktywuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktywujActionPerformed(evt);
            }
        });
        aktywuj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aktywujKeyPressed(evt);
            }
        });

        wyslijKodPonownie.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        wyslijKodPonownie.setText("Wyślij kod ponownie");
        wyslijKodPonownie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyslijKodPonownieActionPerformed(evt);
            }
        });
        wyslijKodPonownie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                wyslijKodPonownieKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(kodAktywacyjnyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(kodAktywacyjnyField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wyslijKodPonownie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cofnij)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aktywuj)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kodAktywacyjnyField)
                    .addComponent(kodAktywacyjnyText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cofnij)
                        .addComponent(aktywuj))
                    .addComponent(wyslijKodPonownie))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("Magazyn - aktywacja konta");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cofnijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cofnijActionPerformed
        this.dispose();
    }//GEN-LAST:event_cofnijActionPerformed

    private void cofnijKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cofnijKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            cofnij.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            kodAktywacyjnyField.requestFocusInWindow();
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            aktywuj.requestFocusInWindow();
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            wyslijKodPonownie.requestFocusInWindow();
        }
    }//GEN-LAST:event_cofnijKeyPressed

    private void kodAktywacyjnyFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodAktywacyjnyFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            aktywuj.doClick();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            aktywuj.requestFocusInWindow();
        }
        if (keyCode == KeyEvent.VK_UP) {
            emailField.requestFocusInWindow();
        }
    }//GEN-LAST:event_kodAktywacyjnyFieldKeyPressed

    private void aktywujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktywujActionPerformed
        //CHECK IF EMAIL NOT EMPTY
        if (emailField.getText().length() > 0) {

            try {
                boolean poprawnoscEmail = true, aktywacja;

                //CHECK IF NOT ACTIVATED YET
                result = statement.executeQuery("select aktywacja from pracownicy where email like '" + emailField.getText() + "'");
                result.next();

                boolean bazaAktywacja = result.getBoolean("aktywacja");

                if (bazaAktywacja == false) {
                    //CHECK EMAIL
                    try {
                        InternetAddress emailAddr = new InternetAddress(emailField.getText());
                        emailAddr.validate();

                    } catch (AddressException ex) {
                        poprawnoscEmail = false;
                        JOptionPane.showMessageDialog(null, "Sprawdź poprawność adresu e-mail!", "Błąd", JOptionPane.ERROR_MESSAGE);

                    }

                    if (poprawnoscEmail) {
                        //GET ACTIVATION CODE FROM DATABASE
                        result = statement.executeQuery("select imię, nazwisko, id, kodAktywacyjny from pracownicy where email like '" + emailField.getText() + "'");

                        result.next();
                        String codeBase = result.getString("kodAktywacyjny");
                        String codeProgram = kodAktywacyjnyField.getText();
                        String id = result.getString("id");
                        String name = result.getString("imię");
                        String surname = result.getString("nazwisko");

                        if (codeBase.equals(codeProgram)) {
                            //ACTIVATE
                            statement.executeUpdate("UPDATE `pracownicy` SET `aktywacja` = b'1' WHERE `pracownicy`.`id` = " + id + ";");
                            aktywacja = true;

                        } else {
                            aktywacja = false;
                            JOptionPane.showMessageDialog(null, "Kody nie są takie same!", "Błąd", JOptionPane.ERROR_MESSAGE);

                        }

                        if (aktywacja) {
                            JOptionPane.showMessageDialog(null, "Aktywowano konto: " + name + " " + surname, "Logowanie", JOptionPane.DEFAULT_OPTION);
                            this.dispose();

                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Konto zostało już aktywowane!", "Błąd", JOptionPane.ERROR_MESSAGE);

                }

            } catch (SQLException exc) {
                JOptionPane.showMessageDialog(null, "Błąd przy aktywacji konta", "Błąd", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "E-mail nie może być pusty!", "Błąd", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_aktywujActionPerformed

    private void aktywujKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aktywujKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            aktywuj.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            kodAktywacyjnyField.requestFocusInWindow();
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            cofnij.requestFocusInWindow();
        }
    }//GEN-LAST:event_aktywujKeyPressed

    private void emailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            kodAktywacyjnyField.requestFocusInWindow();
        }

    }//GEN-LAST:event_emailFieldKeyPressed

    private void wyslijKodPonownieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyslijKodPonownieActionPerformed
        int codeBase;
        boolean activation;

        try {
            InternetAddress emailAddr = new InternetAddress(emailField.getText());
            emailAddr.validate();

            try {
                result = statement.executeQuery("select aktywacja, kodAktywacyjny from pracownicy where email like '" + emailField.getText() + "'");

                result.next();
                codeBase = result.getInt("kodAktywacyjny");
                activation = result.getBoolean("aktywacja");

                if (activation == false) {
                    Email.sendEmail(emailField.getText(), "Aktywacja konta MAGAZYN ", "<h3>Aktywacja konta</h3><br>Tw&#243;j kod aktywacyjny to: " + codeBase + "<br>Aktywuj konto w aplikacji zanim si&#281; zalogujesz!", "Wysłano wiadomość na adres: " + emailField.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Konto o podanym adresie e-mail zostało już aktywowane!", "Już aktywowano", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException exc) {
                JOptionPane.showMessageDialog(null, "W bazie danych nie ma takiego adresu e-mail!", "Błąd", JOptionPane.ERROR_MESSAGE);

            }

        } catch (AddressException ex) {
            JOptionPane.showMessageDialog(null, "Sprawdź poprawność adresu e-mail!", "Błąd", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_wyslijKodPonownieActionPerformed

    private void wyslijKodPonownieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wyslijKodPonownieKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            wyslijKodPonownie.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            kodAktywacyjnyField.requestFocusInWindow();
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            cofnij.requestFocusInWindow();
        }
    }//GEN-LAST:event_wyslijKodPonownieKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aktywuj;
    private javax.swing.JButton cofnij;
    private javax.swing.JTextField emailField;
    private java.awt.Label emailText;
    private javax.swing.JTextField kodAktywacyjnyField;
    private java.awt.Label kodAktywacyjnyText;
    private javax.swing.JButton wyslijKodPonownie;
    // End of variables declaration//GEN-END:variables
}
