/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingAccountSystem.Manipulate;

import BankingAccountSystem.Class.Staff;
import BankingAccountSystem.LoginandPage.Staff_page;
import BankingAccountSystem.Tool_Group.ConnectionClass;
import java.util.ArrayList;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author HATTORI BAMBI
 */
public class Manipulate_Staff extends javax.swing.JFrame {

    /**
     * Creates new form Manipulate_Staff
     */
    DefaultTableModel model;
    private static boolean showTime = true;
    public Manipulate_Staff() {
        initComponents();
    }
    public ArrayList<Staff> StaffArrayList(){
        ArrayList<Staff> StaffArrayList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionClass.connection();
            String sql = "SELECT * FROM Staff";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Staff c;
            while (rs.next()) {
                c = new Staff(
                        rs.getString("Staff_ID"),
                        rs.getString("Staff_name"));
                StaffArrayList.add(c);
            }
            connection.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return StaffArrayList;
    }
    public void show_Staff() {
        ArrayList<Staff>  list = StaffArrayList();
        model = (DefaultTableModel)TableShowStaff.getModel();
        Object[] row = new Object[2];
        for (Staff object: list){
            row[0] = object.getStaff_ID();
            row[1] = object.getStaff_name();
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
        TStaff_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TStaff_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboboxdo = new javax.swing.JComboBox<>();
        BShow_staff = new javax.swing.JButton();
        BRun = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableShowStaff = new javax.swing.JTable();
        Bmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Staff_ID:");

        jLabel2.setText("Staff_name");

        jLabel3.setText("Do");

        comboboxdo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add", "Update", "Delete" }));

        BShow_staff.setText("Show_Staff");
        BShow_staff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BShow_staffActionPerformed(evt);
            }
        });

        BRun.setText("Run");
        BRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRunActionPerformed(evt);
            }
        });

        TableShowStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff_ID", "Staff_name"
            }
        ));
        TableShowStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableShowStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableShowStaff);

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TStaff_ID)
                                .addComponent(TStaff_name)
                                .addComponent(comboboxdo, 0, 117, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BShow_staff)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                            .addComponent(BRun, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(Bmenu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TStaff_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TStaff_name, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboboxdo, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BShow_staff, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(BRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(Bmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BShow_staffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BShow_staffActionPerformed
        // TODO add your handling code here:
        if (showTime) {
            show_Staff();
            showTime = false;
        }
        else {
            model.setRowCount(0);
            show_Staff();
        }
    }//GEN-LAST:event_BShow_staffActionPerformed

    private void TableShowStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableShowStaffMouseClicked
        // TODO add your handling code here:
        int i = TableShowStaff.getSelectedRow();
        TableModel model = TableShowStaff.getModel();
        TStaff_ID.setText(model.getValueAt(i, 0).toString());
        TStaff_name.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_TableShowStaffMouseClicked

    private void BRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRunActionPerformed
        // TODO add your handling code here:
        if (comboboxdo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You need to choose an action!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String doing = comboboxdo.getSelectedItem().toString();
        if (doing.equals("Add")) {
            if (TStaff_ID.getText().length() == 0 || TStaff_name.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Message", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    Connection connection = ConnectionClass.connection();
                        String insertQuery = "INSERT INTO Staff VALUES (?,?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setString(1, TStaff_ID.getText());
                        preparedStatement.setString(2, TStaff_name.getText());
                        preparedStatement.executeUpdate();
                        if (showTime){
                            show_Staff();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_Staff();
                        }
                        JOptionPane.showMessageDialog(null, "Insert completed!");
                        connection.close();
                     
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            
        }
        }
        else if (doing.equals("Update")) {
            if (TStaff_ID.getText().length() == 0 || TStaff_name.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Message", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                        Connection connection = ConnectionClass.connection();
                        String updateQuery = "UPDATE Staff SET Staff_name=? WHERE Staff_ID=?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setString(2, TStaff_ID.getText());
                        preparedStatement.setString(1, TStaff_name.getText());
                        preparedStatement.executeUpdate();
                        if (showTime){
                            show_Staff();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_Staff();
                        }
                        JOptionPane.showMessageDialog(null, "Update completed! Tip: ID cannot be changed.");
                        connection.close();
                     
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
        else { if (TStaff_ID.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "field ID can not be empty!",
                        "Message", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    
                        Connection connection = ConnectionClass.connection();
                        String deleteQuery = "DELETE FROM Staff WHERE Staff_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                        preparedStatement.setString(1, TStaff_ID.getText());
                        preparedStatement.executeUpdate();
                        if (showTime){
                            show_Staff();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_Staff();
                        }
                        JOptionPane.showMessageDialog(null, "Delete completed!");
                        connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_BRunActionPerformed

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
            java.util.logging.Logger.getLogger(Manipulate_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manipulate_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manipulate_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manipulate_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manipulate_Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BRun;
    private javax.swing.JButton BShow_staff;
    private javax.swing.JButton Bmenu;
    private javax.swing.JTextField TStaff_ID;
    private javax.swing.JTextField TStaff_name;
    private javax.swing.JTable TableShowStaff;
    private javax.swing.JComboBox<String> comboboxdo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}