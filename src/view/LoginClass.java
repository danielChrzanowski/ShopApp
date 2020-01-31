package view;

import handling.DBConnection;
import handling.Encryption;
import handling.Employee;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class LoginClass extends javax.swing.JFrame {

    static Connection connection;

    public LoginClass() {
        connection = DBConnection.getDBConnection();

        initComponents();
        loginField.requestFocus(true);
        progressBar.setStringPainted(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginText = new java.awt.Label();
        passwordText = new java.awt.Label();
        loginField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        log_in = new javax.swing.JButton();
        activateAccount = new javax.swing.JLabel();
        recoverPassword = new javax.swing.JLabel();
        addEmployee = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magazyn - logowanie");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/logo.png")));
        setLocation(new java.awt.Point(0, 0));
        setName("Magazyn - logowanie"); // NOI18N
        setResizable(false);

        loginText.setText("login:");

        passwordText.setText("hasło:");

        loginField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loginField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        loginField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginFieldKeyPressed(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passwordField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passwordField.setPreferredSize(new java.awt.Dimension(6, 20));
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        log_in.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        log_in.setText("Zaloguj");
        log_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_inActionPerformed(evt);
            }
        });
        log_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                log_inKeyPressed(evt);
            }
        });

        activateAccount.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        activateAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activateAccount.setText("Aktywuj konto");
        activateAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        activateAccount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                activateAccountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                activateAccountFocusLost(evt);
            }
        });
        activateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activateAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                activateAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                activateAccountMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                activateAccountMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                activateAccountMouseReleased(evt);
            }
        });
        activateAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                activateAccountKeyPressed(evt);
            }
        });

        recoverPassword.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        recoverPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recoverPassword.setText("Odzyskaj hasło");
        recoverPassword.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        recoverPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                recoverPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                recoverPasswordFocusLost(evt);
            }
        });
        recoverPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recoverPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recoverPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recoverPasswordMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                recoverPasswordMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                recoverPasswordMouseReleased(evt);
            }
        });
        recoverPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                recoverPasswordKeyPressed(evt);
            }
        });

        addEmployee.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        addEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addEmployee.setText("Dodaj użytkownika");
        addEmployee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addEmployee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addEmployeeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addEmployeeFocusLost(evt);
            }
        });
        addEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addEmployeeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addEmployeeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addEmployeeMouseReleased(evt);
            }
        });
        addEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addEmployeeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(log_in, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(recoverPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(activateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(log_in, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recoverPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("Magazyn - logowanie");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void log_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event log_inActionPerformed
        requestFocus(false);
        setEnabled(false);

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                String login = loginField.getText();
                char[] getPassword = passwordField.getPassword();
                String password = new String(getPassword);

                //DO SKASOWANIA STATYCZNE LOGOWANIE
                login = "admin";
                password = "admin";
                //KONIEC

                boolean logged;
                Employee employee = Employee.getEmployee();

                try {
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery("select * from pracownicy where login = '" + Encryption.encrypt(login) + "' and hasło = '" + Encryption.encrypt(password) + "'");

                    result.next();
                    boolean activation = result.getBoolean("aktywacja");

                    if (activation) {
                        employee.login = login;
                        employee.password = password;
                        employee.name = result.getString("imię");
                        employee.surname = result.getString("nazwisko");
                        employee.email = result.getString("email");

                        System.out.println("login: " + employee.login + "\nhasło: " + employee.password + "\nimię: " + employee.name + "\nnazwisko: " + employee.surname + "\ne-mail: " + employee.email + "\naktywacja: " + activation + "\n");

                        logged = true;

                    } else {
                        JOptionPane.showMessageDialog(null, "Najpierw aktywuj konto (sprawdź e-mail)!", "Błąd", JOptionPane.ERROR_MESSAGE);
                        logged = false;
                    }

                } catch (SQLException exc) {
                    JOptionPane.showMessageDialog(null, "Zły login lub hasło", "Błąd", JOptionPane.ERROR_MESSAGE);
                    logged = false;
                }

                if (logged) {
                    EmployeeView employeeView = new EmployeeView(progressBar);

                    dispose();
                    employeeView.setVisible(true);

                } else {
                    System.out.println("Nie udało się zalogować!");
                    connection = DBConnection.getDBConnection();
                    setVisible(true);
                    loginField.requestFocus();
                    setEnabled(true);
                }

                return null;
            }
        }.execute();

    }//GEN-LAST:event log_inActionPerformed

    private void log_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event log_inKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            log_in.doClick();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            recoverPassword.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            loginField.requestFocusInWindow();
        }
    }//GEN-LAST:event log_inKeyPressed

    private void activateAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event activateAccountMouseEntered
        editText(activateAccount, java.awt.font.TextAttribute.UNDERLINE, java.awt.font.TextAttribute.UNDERLINE_ON);
    }//GEN-LAST:event activateAccountMouseEntered

    private void activateAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activateAccountMouseExited
        editText(activateAccount, java.awt.font.TextAttribute.UNDERLINE, -1);
    }//GEN-LAST:event_activateAccountMouseExited

    private void activateAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activateAccountMousePressed
        editText(activateAccount, java.awt.font.TextAttribute.SIZE, 9);
    }//GEN-LAST:event_activateAccountMousePressed

    private void activateAccountMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activateAccountMouseReleased
        editText(activateAccount, java.awt.font.TextAttribute.SIZE, 11);
    }//GEN-LAST:event_activateAccountMouseReleased

    private void activateAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activateAccountMouseClicked
        AccountActivation activation = new AccountActivation();
        activation.setVisible(true);
    }//GEN-LAST:event_activateAccountMouseClicked

    private void activateAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_activateAccountKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            AccountActivation activation = new AccountActivation();
            activation.setVisible(true);
        }

        if (keyCode == KeyEvent.VK_UP) {
            addEmployee.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            passwordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_activateAccountKeyPressed

    private void loginFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            passwordField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            log_in.requestFocusInWindow();
        }
    }//GEN-LAST:event_loginFieldKeyPressed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            log_in.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            loginField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            activateAccount.requestFocusInWindow();
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void activateAccountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_activateAccountFocusGained
        editText(activateAccount, java.awt.font.TextAttribute.UNDERLINE, java.awt.font.TextAttribute.UNDERLINE_ON);
    }//GEN-LAST:event_activateAccountFocusGained

    private void activateAccountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_activateAccountFocusLost
        editText(activateAccount, java.awt.font.TextAttribute.UNDERLINE, -1);
    }//GEN-LAST:event_activateAccountFocusLost

    private void recoverPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverPasswordMouseClicked
        RecoverPassword recover = new RecoverPassword();
        recover.setVisible(true);
    }//GEN-LAST:event_recoverPasswordMouseClicked

    private void recoverPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverPasswordMouseEntered
        editText(recoverPassword, java.awt.font.TextAttribute.UNDERLINE, java.awt.font.TextAttribute.UNDERLINE_ON);
    }//GEN-LAST:event_recoverPasswordMouseEntered

    private void recoverPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverPasswordMouseExited
        editText(recoverPassword, java.awt.font.TextAttribute.UNDERLINE, -1);
    }//GEN-LAST:event_recoverPasswordMouseExited

    private void recoverPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverPasswordMousePressed
        editText(recoverPassword, java.awt.font.TextAttribute.SIZE, 9);
    }//GEN-LAST:event_recoverPasswordMousePressed

    private void recoverPasswordMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverPasswordMouseReleased
        editText(recoverPassword, java.awt.font.TextAttribute.SIZE, 11);
    }//GEN-LAST:event_recoverPasswordMouseReleased

    private void recoverPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recoverPasswordKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            RecoverPassword odzyskaj = new RecoverPassword();
            odzyskaj.setVisible(true);
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            addEmployee.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            loginField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            log_in.requestFocusInWindow();
        }
    }//GEN-LAST:event_recoverPasswordKeyPressed

    private void recoverPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_recoverPasswordFocusLost
        editText(recoverPassword, java.awt.font.TextAttribute.UNDERLINE, -1);
    }//GEN-LAST:event_recoverPasswordFocusLost

    private void recoverPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_recoverPasswordFocusGained
        editText(recoverPassword, java.awt.font.TextAttribute.UNDERLINE, java.awt.font.TextAttribute.UNDERLINE_ON);
    }//GEN-LAST:event_recoverPasswordFocusGained

    private void addEmployeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addEmployeeFocusGained
        editText(addEmployee, java.awt.font.TextAttribute.UNDERLINE, java.awt.font.TextAttribute.UNDERLINE_ON);
    }//GEN-LAST:event_addEmployeeFocusGained

    private void addEmployeeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addEmployeeFocusLost
        editText(addEmployee, java.awt.font.TextAttribute.UNDERLINE, -1);
    }//GEN-LAST:event_addEmployeeFocusLost

    private void addEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEmployeeMouseClicked
        AddEmployee add = new AddEmployee();
        add.setVisible(true);
    }//GEN-LAST:event_addEmployeeMouseClicked

    private void addEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEmployeeMouseEntered
        editText(addEmployee, java.awt.font.TextAttribute.UNDERLINE, java.awt.font.TextAttribute.UNDERLINE_ON);
    }//GEN-LAST:event_addEmployeeMouseEntered

    private void addEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEmployeeMouseExited
        editText(addEmployee, java.awt.font.TextAttribute.UNDERLINE, -1);
    }//GEN-LAST:event_addEmployeeMouseExited

    private void addEmployeeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEmployeeMousePressed
        editText(addEmployee, java.awt.font.TextAttribute.SIZE, 9);
    }//GEN-LAST:event_addEmployeeMousePressed

    private void addEmployeeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEmployeeMouseReleased
        editText(addEmployee, java.awt.font.TextAttribute.SIZE, 11);
    }//GEN-LAST:event_addEmployeeMouseReleased

    private void addEmployeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addEmployeeKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            AddEmployee add = new AddEmployee();
            add.setVisible(true);
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            activateAccount.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            passwordField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            recoverPassword.requestFocusInWindow();
        }
    }//GEN-LAST:event_addEmployeeKeyPressed

    public void editText(javax.swing.JLabel object, TextAttribute text1, Integer text2) {
        Font font = object.getFont();
        Map attributes = font.getAttributes();
        attributes.put(text1, text2);
        object.setFont(font.deriveFont(attributes));
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
       
        ConnectingInfo connecting = new ConnectingInfo();
        connecting.setVisible(true);
        connection = DBConnection.getDBConnection();
        connecting.dispose();

        if (connection == null) {
            JOptionPane.showMessageDialog(null, "Nie udało się połączyć z serwerem!", "Błąd", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new LoginClass().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activateAccount;
    private javax.swing.JLabel addEmployee;
    private javax.swing.JButton log_in;
    protected javax.swing.JTextField loginField;
    private java.awt.Label loginText;
    private javax.swing.JPasswordField passwordField;
    private java.awt.Label passwordText;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel recoverPassword;
    // End of variables declaration//GEN-END:variables
}
