package view;

import handling.Photo;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UpdatePhoto extends javax.swing.JFrame {

    File file;
    int id;

    public UpdatePhoto(int id, String nazwa) {
        initComponents();

        this.id = id;
        productData.setText("PRODUKT: " + id + " " + nazwa);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileName = new java.awt.Label();
        chooseFile = new javax.swing.JButton();
        photoText = new java.awt.Label();
        productData = new java.awt.Label();
        changePhoto = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Magazyn - zmiana zdjęcia");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/logo.png")));

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

        photoText.setText("zdjęcie:");

        changePhoto.setText("zmień");
        changePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePhotoActionPerformed(evt);
            }
        });
        changePhoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                changePhotoKeyPressed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(photoText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changePhoto)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseFile)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(photoText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePhoto)
                    .addComponent(back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileActionPerformed
        JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            fileName.setText(file.getName());
            System.out.println("wybrano zdjecie");
        }
    }//GEN-LAST:event_chooseFileActionPerformed

    private void changePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePhotoActionPerformed
        Photo photo = new Photo();
        if (file != null) {
            if (Photo.checkImage(file)) {
                boolean success = photo.updatePhoto(id, file);
                file = null;

                if (success) {
                    JOptionPane.showMessageDialog(null, "Zaktualizowano zdjęcie", "Sukces", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                }
            } else {
                //JOptionPane.showMessageDialog(null, "Wybrany plik nie jest zdjęciem .jpg!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Musisz wybrać zdjęcie!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_changePhotoActionPerformed

    private void chooseFileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chooseFileKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_DOWN) {
            changePhoto.requestFocus(true);
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            chooseFile.doClick();
        }

    }//GEN-LAST:event_chooseFileKeyPressed

    private void changePhotoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changePhotoKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            back.requestFocus(true);
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            changePhoto.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            chooseFile.requestFocus(true);
        }
    }//GEN-LAST:event_changePhotoKeyPressed

    private void backKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_RIGHT) {
            changePhoto.requestFocus(true);
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            this.dispose();
        }

        if (keyCode == KeyEvent.VK_UP) {
            chooseFile.requestFocus(true);
        }

    }//GEN-LAST:event_backKeyPressed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton changePhoto;
    private javax.swing.JButton chooseFile;
    private java.awt.Label fileName;
    private java.awt.Label photoText;
    private java.awt.Label productData;
    // End of variables declaration//GEN-END:variables
}
