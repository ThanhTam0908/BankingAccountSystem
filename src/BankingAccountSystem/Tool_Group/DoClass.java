
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingAccountSystem.Tool_Group;

/**
 *
 * @author HATTORI BAMBI
 */
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
public class DoClass {
    private static final DoClass instance  = new DoClass();
    private DoClass(){}
    public static DoClass getInstance(){
        return instance;
    }
    public static void withdrawal(String moneydo, String moneybefore, String ID){
        try { 
        Connection connection = ConnectionClass.connection();
        String query1 = "INSERT INTO Customer_history VALUES (?,?,?,?)";
        double moneyafter = Double.parseDouble(moneybefore) - Double.parseDouble(moneydo);
        PreparedStatement preparedStatement = connection.prepareStatement(query1);
        preparedStatement.setString(1, ID);
        preparedStatement.setString(2, moneybefore);
        preparedStatement.setString(3, Double.toString(moneyafter));
        preparedStatement.setString(4, "Withdrawal");
        preparedStatement.execute();
        String query2 = "UPDATE Customer SET Customer_money=? WHERE Customer_ID=?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
        preparedStatement2.setString(2, ID);
        preparedStatement2.setString(1,Double.toString(moneyafter));
        preparedStatement2.execute();
        JOptionPane.showMessageDialog(null, "Withdrawal Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
        connection.close();
        } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
        
    }
    public static void recharge(String moneydo, String moneybefore, String ID){
        try { 
        Connection connection = ConnectionClass.connection();
        String query1 = "INSERT INTO Customer_history VALUES (?,?,?,?)";
        double moneyafter = Double.parseDouble(moneybefore) + Double.parseDouble(moneydo);
        PreparedStatement preparedStatement = connection.prepareStatement(query1);
        preparedStatement.setString(1, ID);
        preparedStatement.setString(2, moneybefore);
        preparedStatement.setString(3, Double.toString(moneyafter));
        preparedStatement.setString(4, "Recharge");
        preparedStatement.execute();
        String query2 = "UPDATE Customer SET Customer_money=? WHERE Customer_ID=?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
        preparedStatement2.setString(2, ID);
        preparedStatement2.setString(1,Double.toString(moneyafter));
        preparedStatement2.execute();
        JOptionPane.showMessageDialog(null, "Recharge Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
        connection.close();
        } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
    }
    public static void transfer(String moneydo, String moneybefore,String moneybefore2, String ID1, String ID2){
    try { 
        Connection connection = ConnectionClass.connection();
        String query1 = "INSERT INTO Customer_history VALUES (?,?,?,?)";
        double moneyafter1 = Double.parseDouble(moneybefore) - Double.parseDouble(moneydo);
        PreparedStatement preparedStatement = connection.prepareStatement(query1);
        preparedStatement.setString(1, ID1);
        preparedStatement.setString(2, moneybefore);
        preparedStatement.setString(3, Double.toString(moneyafter1));
        preparedStatement.setString(4, "Transfer");
        preparedStatement.execute();
        
        String query2 = "UPDATE Customer SET Customer_money=? WHERE Customer_ID=?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
        preparedStatement2.setString(2, ID1);
        preparedStatement2.setString(1, Double.toString(moneyafter1));
        preparedStatement2.execute();
        
        double moneyafter2 = Double.parseDouble(moneybefore2) + Double.parseDouble(moneydo);
        String query3 = "INSERT INTO Customer_history VALUES (?,?,?,?)";
        PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
        preparedStatement3.setString(1, ID2);
        preparedStatement3.setString(2, moneybefore2);
        preparedStatement3.setString(3, Double.toString(moneyafter2));
        preparedStatement3.setString(4, "Be transfered");
        preparedStatement3.execute();
        
        String query4 = "UPDATE Customer SET Customer_money=? WHERE Customer_ID=?";
        PreparedStatement preparedStatement4 = connection.prepareStatement(query4);
        preparedStatement4.setString(2, ID2);
        preparedStatement4.setString(1, Double.toString(moneyafter2));
        preparedStatement4.execute();
        JOptionPane.showMessageDialog(null, "Transfer Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
        connection.close();
        } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
    }
}
