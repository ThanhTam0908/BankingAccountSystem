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
public class ConnectionClass {
    private static Connection connection;

    public static Connection connection(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=BankingAccountSystem;user=sa;password=12");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
