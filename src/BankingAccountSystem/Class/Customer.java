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
public class Customer {
    private String Customer_ID;
    private String Customer_name;
    private String Customer_gender;
    private String Customer_phone;
    private String Customer_address;
    private String Card_ID;
    private double Customer_money;

    public Customer(String Customer_ID, String Customer_name, String Customer_gender, String Customer_phone, String Customer_address, String Card_ID, double Customer_money) {
        this.Customer_ID = Customer_ID;
        this.Customer_name = Customer_name;
        this.Customer_gender = Customer_gender;
        this.Customer_phone = Customer_phone;
        this.Customer_address = Customer_address;
        this.Card_ID = Card_ID;
        this.Customer_money = Customer_money;
    }

    public double getCustomer_money() {
        return Customer_money;
    }

    public void setCustomer_money(double Customer_money) {
        this.Customer_money = Customer_money;
    }
    
    public String getCustomer_ID() {
        return Customer_ID;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public String getCustomer_gender() {
        return Customer_gender;
    }

    public String getCustomer_phone() {
        return Customer_phone;
    }

    public String getCustomer_address() {
        return Customer_address;
    }
    
    public String getCard_ID() {
        return Card_ID;
    }

    
}
