package view;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import handling.DBConnection;
import handling.Photo;

public class AddProduct extends javax.swing.JFrame {

    File file;
    String[] categories = null;

    public AddProduct(EmployeeView view) {
        //DELETE 1ST ELEMENT "Wszystkie"
        int length = view.categories.length;
        categories = new String[length - 1];

        for (int i = 0; i < length - 1; i++) {
            categories[i] = view.categories[i + 1];
        }

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addProductText = new java.awt.Label();
        add = new javax.swing.JButton();
        back = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        nameText = new java.awt.Label();
        quantityText = new java.awt.Label();
        quantityField = new javax.swing.JTextField();
        photoText = new java.awt.Label();
        fileName = new java.awt.Label();
        chooseFile = new javax.swing.JButton();
        categoryText = new java.awt.Label();
        categoriesComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Magazyn - dodaj produkt");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/logo.png")));
        setResizable(false);

        addProductText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addProductText.setText("Dodaj produkt");

        add.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        add.setText("dodaj");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addKeyPressed(evt);
            }
        });

        back.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        back.setText("cofnij");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        back.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backKeyPressed(evt);
            }
        });

        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameFieldKeyPressed(evt);
            }
        });

        nameText.setText("nazwa:");

        quantityText.setText("ilość:");

        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityFieldKeyPressed(evt);
            }
        });

        photoText.setText("zdjęcie:");

        fileName.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        fileName.setText("nazwa pliku.jpg");

        chooseFile.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        chooseFile.setText("wybierz");
        chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileActionPerformed(evt);
            }
        });
        chooseFile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chooseFileKeyPressed(evt);
            }
        });

        categoryText.setText("kategoria:");

        categoriesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(categories));
        categoriesComboBox.setKeySelectionManager(null);
        categoriesComboBox.setLightWeightPopupEnabled(false);
        categoriesComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                categoriesComboBoxFocusGained(evt);
            }
        });
        categoriesComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoriesComboBoxKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(addProductText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(photoText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(categoryText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(categoriesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantityField, javax.swing.GroupLayout.Alignment.LEADING))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addProductText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(categoryText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(categoriesComboBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(photoText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseFile))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("Magazyn - dodaj produkt");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        boolean correctness = checkData();

        if (correctness) {
            if (checkIfNotInBase()) {
                if (file != null) {
                    if (Photo.checkImage(file)) {
                        int last = insertProduct();

                        Photo photo = new Photo();
                        photo.updatePhoto(last, file);
                        file = null;

                    }
                } else {
                    insertProduct();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Produkt o podanej nazwie jest już w bazie!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addActionPerformed

    private boolean checkIfNotInBase() {
        int selectedID = -1;

        try {
            Connection connection = DBConnection.getDBConnection();
            Statement statement = connection.createStatement();
            ResultSet result;

            result = statement.executeQuery("select id from produkty where nazwa = '" + nameField.getText() + "';");
            result.next();

            selectedID = result.getInt("id");

        } catch (SQLException exc) {
            System.out.println("Błąd w klasie AddProduct.checkIfNotInBase");
        }

        return selectedID == -1;
    }

    private int insertProduct() {
        int last = Integer.MAX_VALUE;

        try {
            Connection connection = DBConnection.getDBConnection();
            Statement statement = connection.createStatement();
            ResultSet result;

            statement.executeUpdate("insert into produkty (nazwa, ilość, kategoria) values ('" + nameField.getText() + "','" + quantityField.getText() + "','" + categoriesComboBox.getSelectedItem().toString() + "');");

            result = statement.executeQuery("select id from produkty where nazwa='" + nameField.getText() + "';");
            result.next();

            last = result.getInt("id");
            System.out.println("ostatni: " + last);

            JOptionPane.showMessageDialog(null, "ID: " + last + "\nNazwa: " + nameField.getText() + "\nIlość: " + quantityField.getText(), "Dodano produkt", JOptionPane.DEFAULT_OPTION);
            nameField.setText("");
            quantityField.setText("");
            fileName.setText("nazwa pliku.jpg");
            nameField.requestFocus(true);

        } catch (SQLException exc) {
            System.out.println("Błąd w klasie AddProduct.insertProduct");
        }

        return last;
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            add.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            chooseFile.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            back.requestFocusInWindow();
        }
    }//GEN-LAST:event_addKeyPressed

    private void backKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            back.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            chooseFile.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            add.requestFocusInWindow();
        }
    }//GEN-LAST:event_backKeyPressed

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            quantityField.requestFocusInWindow();
        }
    }//GEN-LAST:event_nameFieldKeyPressed

    private void quantityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            categoriesComboBox.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            nameField.requestFocusInWindow();
        }
    }//GEN-LAST:event_quantityFieldKeyPressed

    private void chooseFileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chooseFileKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            chooseFile.doClick();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            add.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            categoriesComboBox.requestFocusInWindow();
        }

    }//GEN-LAST:event_chooseFileKeyPressed

    private void categoriesComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoriesComboBoxKeyPressed
        int keyCode = evt.getKeyCode();
        int selectedIndex = categoriesComboBox.getSelectedIndex();

        if (keyCode == KeyEvent.VK_UP) {
            if (selectedIndex == 0) {
                quantityField.requestFocusInWindow();
            }
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            int length = categoriesComboBox.getItemCount();
            if (selectedIndex == length - 1) {
                chooseFile.requestFocusInWindow();
            }
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            chooseFile.requestFocusInWindow();
        }
    }//GEN-LAST:event_categoriesComboBoxKeyPressed

    private void categoriesComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categoriesComboBoxFocusGained
        categoriesComboBox.showPopup();
    }//GEN-LAST:event_categoriesComboBoxFocusGained

    private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileActionPerformed
        JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            fileName.setText(file.getName());
        }
    }//GEN-LAST:event_chooseFileActionPerformed

    boolean checkData() {
        String name = nameField.getText();
        String quantity = quantityField.getText();
        int nameLength = name.length();
        int quantityLength = quantity.length();

        if (nameLength < 1 || quantityLength < 1) {
            JOptionPane.showMessageDialog(null, "Musisz wpisać nazwę i ilość!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (nameLength > 40) {
            JOptionPane.showMessageDialog(null, "Nazwa jest za długa!\nMax 40 znaków", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            // checking valid integer using parseInt() method 
            Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Musisz wpisać liczbę w polu \"ilość\"", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Long compareNumber = Long.parseLong(quantity);
        if (compareNumber > Integer.MAX_VALUE) {
            JOptionPane.showMessageDialog(null, "Liczba jest za duża!\nMaksymalny rozmiar typu Integer to: 2 147 483 647", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private java.awt.Label addProductText;
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> categoriesComboBox;
    private java.awt.Label categoryText;
    private javax.swing.JButton chooseFile;
    private java.awt.Label fileName;
    private javax.swing.JTextField nameField;
    private java.awt.Label nameText;
    private java.awt.Label photoText;
    private javax.swing.JTextField quantityField;
    private java.awt.Label quantityText;
    // End of variables declaration//GEN-END:variables
}
