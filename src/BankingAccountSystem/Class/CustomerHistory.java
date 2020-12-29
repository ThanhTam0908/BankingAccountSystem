/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingAccountSystem.Class;

/**
 *
 * @author HATTORI BAMBI
 */
public class CustomerHistory {
    private String Customer_ID;
    private double Money_beforedo;
    private double Money_afterdo;
    private String Do;

    public String getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(String Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public double getMoney_beforedo() {
        return Money_beforedo;
    }

    public void setMoney_beforedo(double Money_beforedo) {
        this.Money_beforedo = Money_beforedo;
    }

    public double getMoney_afterdo() {
        return Money_afterdo;
    }

    public void setMoney_afterdo(double Money_afterdo) {
        this.Money_afterdo = Money_afterdo;
    }

    public String getDo() {
        return Do;
    }

    public void setDo(String Do) {
        this.Do = Do;
    }

    public CustomerHistory(String Customer_ID, double Money_beforedo, double Money_afterdo, String Do) {
        this.Customer_ID = Customer_ID;
        this.Money_beforedo = Money_beforedo;
        this.Money_afterdo = Money_afterdo;
        this.Do = Do;
    }
}
