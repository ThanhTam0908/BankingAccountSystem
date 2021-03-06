/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingAccountSystem.Manipulate;

import BankingAccountSystem.Class.Card;
import BankingAccountSystem.LoginandPage.Staff_page;
import BankingAccountSystem.Tool_Group.ConnectionClass;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HATTORI BAMBI
 */
public class Manipulate_Card extends javax.swing.JFrame {
    DefaultTableModel model;
    private static boolean showTime = true;
    /**
     * Creates new form Manipulate_Card
     */
    public Manipulate_Card() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public ArrayList<Card> CardArrayList(){
        ArrayList<Card> CardArrayList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionClass.connection();
            String sql = "SELECT * FROM Card";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Card c;
            while (rs.next()) {
                c = new Card(
                        rs.getString("Card_ID"),
                        rs.getString("Card_name"));
                CardArrayList.add(c);
            }
            connection.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return CardArrayList;
    }
    public void show_Card() {
        ArrayList<Card>  list = CardArrayList();
        model = (DefaultTableModel)TableShowCard.getModel();
        Object[] row = new Object[2];
        for (Card card: list){
            row[0] = card.getCard_ID();
            row[1] = card.getCard_name();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TCard_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TCard_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BShow = new javax.swing.JButton();
        BRun = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableShowCard = new javax.swing.JTable();
        comboboxdo = new javax.swing.JComboBox<>();
        Bmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Card_ID:");

        TCard_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCard_IDActionPerformed(evt);
            }
        });

        jLabel2.setText("Card_name:");

        TCard_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCard_nameActionPerformed(evt);
            }
        });

        jLabel3.setText("DO:");

        BShow.setText("Show_Card");
        BShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BShowMouseClicked(evt);
            }
        });
        BShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BShowActionPerformed(evt);
            }
        });

        BRun.setText("Run");
        BRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRunActionPerformed(evt);
            }
        });

        TableShowCard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Card_ID", "Card_name"
            }
        ));
        TableShowCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableShowCardMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableShowCard);

        comboboxdo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add", "Update", "Delete" }));
        comboboxdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxdoActionPerformed(evt);
            }
        });

        Bmenu.setText("Menu");
        Bmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BShow)
                                .addGap(18, 18, 18)
                                .addComponent(BRun))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TCard_ID, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(TCard_name)
                                    .addComponent(comboboxdo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Bmenu)
                        .addGap(59, 59, 59)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TCard_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TCard_name, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(comboboxdo))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BShow)
                    .addComponent(BRun))
                .addGap(18, 18, 18)
                .addComponent(Bmenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TCard_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCard_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCard_IDActionPerformed

    private void TCard_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCard_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCard_nameActionPerformed

    private void BRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRunActionPerformed
        // TODO add your handling code here:
        if (comboboxdo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You need to choose an action!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String doing = comboboxdo.getSelectedItem().toString();
        if (doing.equals("Add")) {
            if (TCard_ID.getText().length() == 0 || TCard_name.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Message", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    Connection connection = ConnectionClass.connection();
                        String insertQuery = "INSERT INTO Card VALUES (?,?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setString(1, TCard_ID.getText());
                        preparedStatement.setString(2, TCard_name.getText());
                        preparedStatement.executeUpdate();
                        if (showTime){
                            show_Card();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_Card();
                        }
                        JOptionPane.showMessageDialog(null, "Insert completed!");
                        connection.close();
                     
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            
        }
        }
        else if (doing.equals("Update")) {
            if (TCard_ID.getText().length() == 0 || TCard_name.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Message", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                        Connection connection = ConnectionClass.connection();
                        String updateQuery = "UPDATE Card SET Card_name=? WHERE Card_ID=?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setString(2, TCard_ID.getText());
                        preparedStatement.setString(1, TCard_name.getText());
                        preparedStatement.executeUpdate();
                        if (showTime){
                            show_Card();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_Card();
                        }
                        JOptionPane.showMessageDialog(null, "Update completed! Tip: ID cannot be changed.");
                        connection.close();
                     
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
        else { if (TCard_ID.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "field ID can not be empty!",
                        "Message", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    
                        Connection connection = ConnectionClass.connection();
                        String deleteQuery = "DELETE FROM Card WHERE Card_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                        preparedStatement.setString(1, TCard_ID.getText());
                        preparedStatement.executeUpdate();
                        if (showTime){
                            show_Card();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_Card();
                        }
                        JOptionPane.showMessageDialog(null, "Delete completed!");
                        connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_BRunActionPerformed

    private void BShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BShowActionPerformed
        // TODO add your handling code here:
        if (showTime) {
            show_Card();
            showTime = false;
        } else {
            model.setRowCount(0);
            show_Card();
        }
    }//GEN-LAST:event_BShowActionPerformed

    private void BShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BShowMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BShowMouseClicked

    private void TableShowCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableShowCardMouseClicked
        // TODO add your handling code here:
        int i = TableShowCard.getSelectedRow();
        TableModel model = TableShowCard.getModel();
        TCard_ID.setText(model.getValueAt(i, 0).toString());
        TCard_name.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_TableShowCardMouseClicked

    private void comboboxdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxdoActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_comboboxdoActionPerformed

    private void BmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmenuActionPerformed
        // TODO add your handling code here:
        dispose();
        Staff_page.main(new String[] {});
    }//GEN-LAST:event_BmenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manipulate_Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manipulate_Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manipulate_Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manipulate_Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manipulate_Card().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BRun;
    private javax.swing.JButton BShow;
    private javax.swing.JButton Bmenu;
    private javax.swing.JTextField TCard_ID;
    private javax.swing.JTextField TCard_name;
    private javax.swing.JTable TableShowCard;
    private javax.swing.JComboBox<String> comboboxdo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
