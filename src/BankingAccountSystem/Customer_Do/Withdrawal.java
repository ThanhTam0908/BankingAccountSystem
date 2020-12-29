/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingAccountSystem.Customer_Do;

import BankingAccountSystem.LoginandPage.Customer_page;
import BankingAccountSystem.Tool_Group.ConnectionClass;
import BankingAccountSystem.Tool_Group.DoClass;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HATTORI BAMBI
 */
public class Withdrawal extends javax.swing.JFrame {

    /**
     * Creates new form Withdrawal
     */
    private static String real_ID= null;
    private static String role = null;
    private static String full_name = null;
    private static double moneybefore =0.0;
    protected static double overdraft = 500;

    public static double getMoneybefore() {
        return moneybefore;
    }

    public static void setMoneybefore(double moneybefore) {
        Withdrawal.moneybefore = moneybefore;
    }
    
    public static String getLFullname(){
        return full_name;
    }
    public static void setLFullName(String a){
        Withdrawal.full_name = a;
    }
    public static String getReal_ID() {
        return real_ID;
    }

    public static void setReal_ID(String real_ID) {
        Withdrawal.real_ID = real_ID;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        Withdrawal.role = role;
    }
    public Withdrawal() {
        initComponents();
    }
    public void setvisible(){
        dispose();
        Customer_page.main(new String[] {});
    }
    public void withdrawal(){
        if (moneybefore<overdraft){
            JOptionPane.showMessageDialog(null, "You have reach your limit please recharge to do this action");
            Customer_page.main(new String[] {});
        }
        else {
        if (TAmount.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No field can not be empty","Messages", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
        
            DoClass.withdrawal(TAmount.getText(), Double.toString(moneybefore), real_ID);
        }
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
        TAmount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        BConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Amount:");

        TAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TAmountActionPerformed(evt);
            }
        });

        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BConfirm.setText("Confirm");
        BConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(TAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BConfirm)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(BConfirm))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TAmountActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setvisible();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConfirmActionPerformed
        // TODO add your handling code here:
        withdrawal();
    }//GEN-LAST:event_BConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(Withdrawal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Withdrawal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Withdrawal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Withdrawal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Withdrawal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BConfirm;
    protected javax.swing.JTextField TAmount;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}