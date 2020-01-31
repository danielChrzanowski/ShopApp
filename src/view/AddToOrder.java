package view;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddToOrder extends javax.swing.JFrame {

    int id, DBQuantity;
    String name;
    DefaultTableModel givenModel;
    int converted;

    public AddToOrder(int id, String name, int DBQuantity, DefaultTableModel givenModel, String productInfo) {
        this.DBQuantity = DBQuantity;
        this.id = id;
        this.name = name;
        this.givenModel = givenModel;

        initComponents();
        this.setAlwaysOnTop(true);
        productInfoText.setText(productInfo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quantityField = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        accept = new javax.swing.JButton();
        text = new javax.swing.JLabel();
        productInfoText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Zamówienie");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/logo.png")));

        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityFieldKeyPressed(evt);
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

        accept.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        accept.setText("zatwierdź");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });
        accept.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                acceptKeyPressed(evt);
            }
        });

        text.setText("Podaj ilość:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productInfoText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accept))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productInfoText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantityField, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accept)
                    .addComponent(back))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void backKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            back.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            quantityField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            accept.requestFocusInWindow();
        }
    }//GEN-LAST:event_backKeyPressed

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed

        if (checkQuantity()) {
            givenModel.addRow(new Object[]{id, name, converted});
            this.dispose();
        }

    }//GEN-LAST:event_acceptActionPerformed

    private boolean checkQuantity() {
        String askQuantity = (String) quantityField.getText();

        try {
            converted = Integer.parseInt(askQuantity);
            if (converted <= DBQuantity && converted > 0) {
                return true;
            } else {

                if (DBQuantity > 0) {
                    JOptionPane.showMessageDialog(this, "Dozwolony zakres: 1 - " + DBQuantity, "Błąd", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Brak produktu w magazynie!", "Błąd", JOptionPane.ERROR_MESSAGE);
                }

                return false;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Proszę podać liczbę!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    private void acceptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acceptKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            accept.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            quantityField.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            back.requestFocusInWindow();
        }
    }//GEN-LAST:event_acceptKeyPressed

    private void quantityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            accept.doClick();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            accept.requestFocusInWindow();
        }
    }//GEN-LAST:event_quantityFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton back;
    private javax.swing.JLabel productInfoText;
    private javax.swing.JTextField quantityField;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables

}
