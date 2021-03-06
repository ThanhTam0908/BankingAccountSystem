/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingAccountSystem.Customer_Do;

import BankingAccountSystem.LoginandPage.Staff_page;
import BankingAccountSystem.Tool_Group.ConnectionClass;
import BankingAccountSystem.Tool_Group.DoClass;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author HATTORI BAMBI
 */
public class Recharge_Staff extends Recharge {

    /**
     * Creates new form Recharge_Staff
     */
    protected static int length = 0;

    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Recharge_Staff.length = length;
    }
    public void checkExistID(){
        try{ 
                Connection connection = ConnectionClass.connection();
                String query = "SELECT Customer_ID FROM Customer";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    if (TID.getText().equals(rs.getString("Customer_ID"))){
                        Recharge_Staff.setLength(length+1);
                    }
                }
                connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @Override
    public void setvisible(){
        dispose();
        Staff_page.main(new String[] {});
    }
    @Override
    public void recharge(){
        checkExistID();
        if (TAmount.getText().length() == 0 || TID.getText().length()==0) {
            JOptionPane.showMessageDialog(null, "No field can not be empty","Messages", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            if (length==1){
            try{
                Connection connection = ConnectionClass.connection();
                String query = "SELECT * FROM Customer WHERE Customer_ID="+TID.getText();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    setMoneybefore(rs.getDouble(7));
                }
                Recharge_Staff.setLength(0);
                DoClass.recharge(TAmount.getText(), Double.toString(getMoneybefore()), TID.getText());
                connection.close();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            
        } else {
                Recharge_Staff.setLength(0);
                JOptionPane.showMessageDialog(null, "ID does not exist please input again","Message", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    public Recharge_Staff() {
        initComponents();
        setReal_ID(TID.getText());
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
        TID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Customer_ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TID, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Recharge_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recharge_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recharge_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recharge_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recharge_Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TID;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
