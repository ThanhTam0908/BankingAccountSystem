/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingAccountSystem.LoginandPage;

/**
 *
 * @author HATTORI BAMBI
 */
import BankingAccountSystem.Customer_Do.Recharge;
import BankingAccountSystem.Customer_Do.Transfer;
import BankingAccountSystem.Customer_Do.Withdrawal;
import BankingAccountSystem.Manipulate.Manipulate_Customer;
import BankingAccountSystem.Manipulate.Manipulate_CustomerHistory;
import BankingAccountSystem.Tool_Group.ConnectionClass;
import BankingAccountSystem.Tool_Group.Password_To_String;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
public class Login extends javax.swing.JFrame {
    public static int loginfailcount = 0;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        TUsername = new javax.swing.JTextField();
        TPassword = new javax.swing.JPasswordField();
        BSignin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        BSignin.setText("Sign In");
        BSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSigninActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(TPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(BSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(BSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSigninActionPerformed
        // TODO add your handling code here:
        if (TUsername.getText().length() == 0 || TPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Username and Password can not be empty","Messages", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Connection connection = ConnectionClass.connection();
            String passwordtext = Password_To_String.convert(TPassword.getPassword());
            String query = "SELECT * FROM Account WHERE Username=? AND Password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, TUsername.getText());
            preparedStatement.setString(2, passwordtext);
            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()){
                loginfailcount=0;
                JOptionPane.showMessageDialog(null, "Login Successfully");
                String Fullname = resultset.getString(1);
                String stringID = resultset.getString(5);
                double moneybefore;
                
                dispose();
                if (resultset.getString(4).equals("0")){
                     Customer_page customer = new Customer_page();
                     customer.setVisible(true);  
                     customer.setFullname(Fullname);
                     customer.setLFullName();
                     Manipulate_Customer.setReal_ID(stringID);
                     Withdrawal.setReal_ID(stringID);
                     Recharge.setReal_ID(stringID);
                     Transfer.setReal_ID(stringID);
                     Manipulate_CustomerHistory.setReal_ID(stringID);
                    String query1 = "SELECT * FROM Customer WHERE Customer_ID='" + stringID+"'";
                    PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                    ResultSet rs = preparedStatement1.executeQuery();
                    while (rs.next()){
                        moneybefore = rs.getDouble(7);
                        Withdrawal.setMoneybefore(moneybefore);
                        Recharge.setMoneybefore(moneybefore);
                        Transfer.setMoneybefore(moneybefore);
                    }
                     Withdrawal.setLFullName(Fullname);
                     Recharge.setLFullName(Fullname);
                     Transfer.setLFullName(Fullname);
                }
                else if (resultset.getString(4).equals("1")){
                    
                    Staff_page staff = new Staff_page();
                    staff.setVisible(true);
                    staff.setFullname(Fullname);
                    staff.setLFullname();
                    Manipulate_Customer.setReal_ID(stringID);
                    Manipulate_CustomerHistory.setReal_ID(stringID);
                } else if (resultset.getString(4).equals("2")){
                    
                    Staff_page staff = new Staff_page();
                    staff.setVisible(true);
                    staff.setFullname(Fullname);
                    staff.setLFullname();
                    Manipulate_Customer.setReal_ID(stringID);
                    Manipulate_CustomerHistory.setReal_ID(stringID);
                }
            }
            else {
                loginfailcount ++;
                String string = String.format("\n You have %s login left", 5-loginfailcount );
                JOptionPane.showMessageDialog(null, "Login fail please try again" + string, "Message", JOptionPane.WARNING_MESSAGE);
                TUsername.selectAll();
                TUsername.replaceSelection("");
                TPassword.selectAll();
                TPassword.replaceSelection("");

                if (loginfailcount == 5){
                    BSignin.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Please sign up","Message", JOptionPane.WARNING_MESSAGE);
                }
            }
            connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
            
        }
    }//GEN-LAST:event_BSigninActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSignin;
    private javax.swing.JPasswordField TPassword;
    private javax.swing.JTextField TUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
